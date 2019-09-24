package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.dto.APIResponse;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LuoYu on 2019/8/14.
 */
@RequestMapping("/inventory")
public interface IInventoryService {

    /**
     * 新增商品
     */
    @PostMapping("/product/add")
    Product addProduct(Product product) throws APIException;

    /**
     * 根据商品id查询商品
     * @param productId
     */
    @GetMapping("/product/{productId}")
//    @RequestMapping(value = "/product/{productId}",method = RequestMethod.GET)
    Product getProduct(@PathVariable("productId") String productId) throws APIException;

    /**
     * 核查 + 预减库存
     * @param productId 产品id
     */
    @GetMapping("/check/{productId}/{amount}")
//    @RequestMapping(value = "/inventory/check/{productId}/{amount}",method = RequestMethod.GET)
    Product checkInventory(@PathVariable("productId") String productId,
                               @PathVariable("amount") Integer amount) throws APIException;

    /**
     *
     */
    @PostMapping("deduct")
    void deductInventory() throws APIException;
}
