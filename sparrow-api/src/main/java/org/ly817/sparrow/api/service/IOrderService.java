package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;

import org.ly817.sparrow.api.pojo.Order;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 */
@RequestMapping
public interface IOrderService {

    /**
     * 提交订单
     * 订单提交和支付流程是异步进行的
     *
     *
     * - 校验订单
     *   - 校验库存是否足够
     *   - 校验购物券是否存在
     *   - 校验金额:验证前端计算的金额
     * - 生成预订单
     *   - 减库存
     *   - 作废购物券
     *   - 生成记录订单表
     *   - todo *通知商户
     *
     *
     *
     * - 调用付款接口
     *   - 调用成功
     *     - 修改订单状态
     *     - 加积分
     *     - 物流
     *     - 通知客户端
     *   - 调用失败
     *     - 回滚库存、购物券
     *
     * 不可预期异常
     * - 服务调用超时导致的数据不一致
     * - 重试与接口的幂等性
     *
     * @param order
     */
    @PostMapping("orders")
    Order addPreOrder(@RequestBody Order order);

    /**
     * 确认订单
     * 支付成功 将预订单状态的订单进行更新为已支付 并开启后续履约流程
     *
     * @param order
     */
    @PatchMapping("orders/confirm")
    Order confirmPreOrder(@RequestBody Order order);

    /**
     * 取消订单
     *
     * 下单与支付分开
     * 会在下单之后开启一个倒计时，需要在倒计时结束之前完成支付操作，否则订单会被取消
     * @param order
     */
    @PatchMapping("orders/rollback")
    Order rollbackPreOrder(@RequestBody Order order);
}
