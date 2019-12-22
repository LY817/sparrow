package org.ly817.sparrow.order;

import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;

import org.ly817.sparrow.api.pojo.Coupon;
import org.ly817.sparrow.api.pojo.Order;
import org.ly817.sparrow.api.pojo.OrderProductLog;
import org.ly817.sparrow.api.pojo.Product;
import org.ly817.sparrow.api.service.ICouponService;
import org.ly817.sparrow.api.service.IOrderService;

import org.ly817.sparrow.api.service.IProductService;
import org.ly817.sparrow.api.service.ITradeLogService;
import org.ly817.sparrow.common.SnowflakeIdWorker;
import org.ly817.sparrow.order.dao.OrderDao;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LY
 * @date 2019/08/16 9:24
 * <p>
 * Description:
 * 订单微服务实现类
 */
@RestController
public class OrderServiceImpl implements IOrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private IProductService productService;

    @Autowired
    private ICouponService couponService;

    @Autowired
    private ITradeLogService tradeLogService;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Autowired
    private Redisson redisson;

    @Autowired
    private OrderDao orderDao;

    /**
     * 创建预订单，等待支付成功
     * - todo *等待时间5分钟 使用延时消息
     *
     * todo 使用mq进行一下操作
     * 生成后等待支付操作回调
     * - 扣库存
     * - 用优惠券
     * - 加积分
     */
    @Override
    public Order addPreOrder(@RequestBody Order order) {
        // 检查订单
        checkOrder(order);
        // 保存预订单
        Long orderId = savePreOrder(order);
        reduceProductInventory(order);
        orderDao.insert(order);
        // todo 开启订单倒计时
        return order;
    }

    /**
     * 确认订单
     *
     * 支付成功 将预订单状态的订单进行更新为已支付
     * 关闭订单倒计时
     * 并开启后续履约流程
     *
     * @param order
     * @return
     */
    @Override
    public Order confirmPreOrder(Order order) {
        return null;
    }

    /**
     * 关闭预订单
     * @param order
     * @return
     */
    @Override
    public Order rollbackPreOrder(Order order) {
        return null;
    }

    /**
     * 防止超卖 悲观锁，分布式锁，乐观锁，队列串行化，异步队列分散，Redis原子操作
     * 使用redisson分布式锁实现
     * @param order
     */
    private void reduceProductInventory(Order order) {
        RLock lock = redisson.getLock(order.getProductId()+"");
        lock.lock();
        // todo 加锁、解锁
        try {
            productService.updateProductInventory(order.getProductId(),- order.getNumber());
        } finally {
            lock.unlock();
        }
        // orderProductLog数据库操作日志
        tradeLogService.addOrderProductLog(OrderProductLog.builder()
                .productId(order.getProductId())
                .orderId(order.getOrderId())
                .number(order.getNumber())
                .logTime(new Date()).build());
    }

    /**
     * 校验订单 商品相关
     * - 校验库存是否足够
     *
     * 查询对应商品和用户，并对对象的属性经验验证
     */
    private void checkOrder(Order order) {
        Product product = productService.getProduct(order.getProductId());
        if (product == null) {
            throw new APIException(APIExceptionType.PRODUCT_NOT_EXIST);
        }
        // 如何处理并发访问时的超减库存的问题：乐观锁、预减机制
        // TODO https://gitee.com/luoyu817/sparrow/issues/I1447F
        if (order.getNumber() > product.getInventory()) {
            throw new APIException(APIExceptionType.INVENTORY_NOT_ENOUGH);
        }

        if (order.getProductPrice().compareTo(product.getPrice()) != 0) {
            throw new APIException(APIExceptionType.ORDER_INVALID_PRICE);
        }

        if (order.getNumber() > product.getInventory()) {
            throw new APIException(APIExceptionType.ORDER_NUMBER_OVER);
        }
    }

    /**
     * 生成预订单
     * - 校验金额:验证前端计算的金额
     * - 减库存
     * - 作废购物券
     */
    private Long savePreOrder(Order order) {
        Long orderId = idWorker.nextId();
        //1 设置订单状态为不可见
        order.setOrderSts(Order.ORDER_NO_CONFIRM);
        //2 设置订单ID
        // 生成订单号
        order.setOrderId(orderId);
        //4 核算订单总金额是否合法
        if (order.getOrderAmount().compareTo(order.getProductPrice()
                .multiply(new BigDecimal(order.getProductNumber()))) != 0) {
            throw new APIException(APIExceptionType.ORDER_AMOUNT_INVALID);
        }
        order.setPayAmount(order.getOrderAmount().add(order.getShippingFee()));
        //5 验证优惠券状态
        if (order.getCouponId() != null) {
            Coupon coupon = couponService.getCouponById(order.getCouponId());
            if (coupon == null) {
                throw new APIException(APIExceptionType.COUPON_NOT_EXIST);
            }
            if (coupon.getCouponSts() == 1) {
                throw new APIException(APIExceptionType.COUPON_NOT_USED);
            }
            //6 核算订单支付金额 订单总金额 - 余额 - 优惠券金额
            order.setCouponPaid(coupon.getCouponPrice());
            order.setMoneyPaid(order.getPayAmount().subtract(coupon.getCouponPrice()));
            //7 作废优惠券
            coupon.setCouponSts(1);
            coupon.setOrderId(orderId);
            couponService.addCoupon(coupon);
        } else {
            order.setCouponPaid(new BigDecimal(0));
            order.setMoneyPaid(order.getPayAmount());
        }
        order.setCreateTime(new Date());
        return orderId;
    }
}
