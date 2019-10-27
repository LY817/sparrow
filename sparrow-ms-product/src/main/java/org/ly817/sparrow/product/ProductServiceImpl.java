package org.ly817.sparrow.product;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.feign.FProductService;

import org.ly817.sparrow.api.pojo.Product;
import org.ly817.sparrow.api.pojo.ProductExample;
import org.ly817.sparrow.common.SnowflakeIdWorker;
import org.ly817.sparrow.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
    public Product addProduct(Product product) throws APIException {
        product.setProductId(idWorker.nextId());
        productDao.insert(product);
        return null;
    }

    @Override
    public Product getProduct(Long productId) throws APIException {
        return null;
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

        }
        return null;
    }
}
