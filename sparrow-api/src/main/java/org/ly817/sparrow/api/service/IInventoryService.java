package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Product;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LuoYu on 2019/8/14.
 */
@Deprecated
//@RequestMapping
public interface IInventoryService {

    /**
     * 新增商品
     */
    @PostMapping("/products")
    Product addProduct(Product product) throws APIException;

    /**
     * 根据商品id查询商品
     * @param productId
     */
    @GetMapping("/products/{productId}")
    Product getProduct(@PathVariable("productId") String productId) throws APIException;

    /**
     * 核查 + 预减库存
     * @param productId 产品id
     *
     * todo 这个用rest风格的接口怎么设计
     */
    @GetMapping("/products/{productId}/{amount}")
    Product checkInventory(@PathVariable("productId") String productId,
                               @PathVariable("amount") Integer amount) throws APIException;

    /**
     *
     */
    @PatchMapping("products/inventory/{amount}")
    void deductInventory() throws APIException;
}
