package org.ly817.sparrow.order;

import org.ly817.sparrow.api.exception.APIException;
//import org.ly817.sparrow.api.feign.FCreditService;
import org.ly817.sparrow.api.feign.FInventoryService;
//import org.ly817.sparrow.api.feign.FPayService;
import org.ly817.sparrow.api.model.Order;
import org.ly817.sparrow.api.service.IOrderService;
import org.ly817.sparrow.common.UUIDUtil;
import org.ly817.sparrow.order.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    private FInventoryService inventoryService;

    @Autowired
    private OrderDao orderDao;

//    @Autowired
//    private FPayService payService;

//    @Autowired
//    private FCreditService creditService;

    @Override
    public void addOrder(@RequestBody Order order) throws APIException {
        order.setOrderId(UUIDUtil.getUUID());
        inventoryService.checkInventory(order.getProductId(),order.getNumber());
//        payService.payCheck("",13.4d);

//        inventoryService.deductInventory();
    }
}
