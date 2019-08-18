package org.ly817.sparrow.inventory.service;

import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Product;
import org.ly817.sparrow.api.service.IInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LY
 * @date 2019/08/14 16:32
 * <p>
 * Description:
 * 库存微服务实现
 */
@RestController
public class InventoryServiceImpl implements IInventoryService {

    private final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void addProduct(@RequestBody Product product) {
        redisTemplate.opsForHash().put("product", product.getProductId(), product);
        logger.info(product.toString());
    }

    @Override
    public Product getProduct(@PathVariable("productId") Long productId) {
        Object product = redisTemplate.opsForHash().get("product", productId);
        return (Product) product;
    }

    @Override
    public void checkInventory(@PathVariable("productId") Long productId,
                               @PathVariable("amount") Integer amount) throws APIException {
        Product product = (Product) redisTemplate.opsForHash().get("product", productId);
        if (product != null) {
            if (product.getInventory() >= amount) {
                product.setInventory(product.getInventory() - amount);
            } else {
                throw new APIException(APIExceptionType.INVENTORY_NOT_ENOUGH);
            }
        } else {
            throw new APIException(APIExceptionType.NPE, productId + "");
        }
    }

    @Override
    public void deductInventory() {
        System.out.println("deductInventory");
    }
}
