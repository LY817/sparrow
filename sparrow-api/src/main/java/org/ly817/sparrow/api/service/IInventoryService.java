package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 */
@FeignClient(value = "sparrow-ms-inventory")
@RequestMapping("sparrow-ms-inventory")
public interface IInventoryService {

    /**
     * 新增商品
     */
    @PostMapping("/product/add")
    void addProduct(Product product);

    /**
     * 根据商品id查询商品
     * @param productId
     */
    @GetMapping("/product/{productId}")
    Product getProduct(@PathVariable Long productId);

    /**
     * 核查 + 预减库存
     * @param productId 产品id
     */
    @PostMapping("check")
    void checkInventory(Long productId);

    /**
     *
     */
    @PostMapping("deduct")
    void deductInventory();
}
