package org.ly817.sparrow.product;

import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.feign.FProductService;

import org.ly817.sparrow.api.pojo.Product;
import org.ly817.sparrow.api.pojo.ProductExample;
import org.ly817.sparrow.common.SnowflakeIdWorker;
import org.ly817.sparrow.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author LY
 * @date 2019/10/27 16:35
 * <p>
 * Description:
 */
@RestController
public class ProductServiceImpl implements FProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Override
    public Product addProduct(@RequestBody Product product) throws APIException {
        product.setProductId(idWorker.nextId());
        product.setAddTime(new Date());
        productDao.insert(product);
        return product;
    }

    @Override
    public Product getProduct(@PathVariable("productId") Long productId) throws APIException {
        return productDao.selectByPrimaryKey(productId);
    }

    @Override
    public Product checkProductInventory(Long productId, Integer checkNumber) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andInventoryGreaterThan(checkNumber);
        productExample.or(criteria);
        List<Product> list = productDao.selectByExample(productExample);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            throw new APIException(APIExceptionType.INVENTORY_NOT_ENOUGH);
        }
    }

    /**
     * 扣减库存 未考虑并发
     * @param productId 商品id
     * @param number 扣减商品数
     */
    @Override
    public void updateProductInventory(@PathVariable("productId") Long productId,
                                       @PathVariable("number") Integer number) {
        int result = productDao.updateInventoryByProductId(productId,number);
        if (result == 0){
            throw new APIException(APIExceptionType.INVENTORY_NOT_ENOUGH);
        }
    }
}
