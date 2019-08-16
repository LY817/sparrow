package org.ly817.sparrow.inventory.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Order;
import org.ly817.sparrow.api.service.IInventoryService;
import org.ly817.sparrow.api.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LY
 * @date 2019/08/16 9:24
 * <p>
 * Description:
 * 订单微服务实现类
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private IInventoryService inventoryService;

    @Override
    public void addOrder(Order order) throws APIException {
        logger.info(order.toString());
        inventoryService.checkInventory(order.getProductId(),order.getNumber());
    }
}
