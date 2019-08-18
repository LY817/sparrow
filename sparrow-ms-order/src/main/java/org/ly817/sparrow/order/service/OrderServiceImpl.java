package org.ly817.sparrow.order.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.fegin.FInventoryService;
import org.ly817.sparrow.api.model.Order;
import org.ly817.sparrow.api.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void addOrder(Order order) throws APIException {
        logger.info(order.toString());
        inventoryService.checkInventory(order.getProductId(),order.getNumber());
//        inventoryService.deductInventory();
    }
}
