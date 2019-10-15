package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/10/11.
 * 商品服务
 */
@RequestMapping
public interface IProductService {
    /**
     * 新增商品
     *
     * todo REST风格的接口设计
     * - uri 定位资源
     * - 访问方法 对资源的操作
     *
     *
     */
    @PostMapping("/products")
    Product addProduct(Product product) throws APIException;

    /**
     * 根据商品id查询商品
     * @param productId
     */
    @GetMapping("/products/{productId}")
    Product getProduct(@PathVariable("productId") String productId) throws APIException;
}
