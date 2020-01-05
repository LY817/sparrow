package org.ly817.sparrow.api.service;



import org.ly817.sparrow.api.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LuoYu on 2019/10/11.
 * 商品服务
 */
@FeignClient(value = "sparrow-ms-product")
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
    Product addProduct(@RequestBody Product product);

    /**
     * 根据商品id查询商品
     * @param productId
     */
    @GetMapping("/products/{productId}")
    Product getProduct(@PathVariable("productId") Long productId);

    /**
     * 检查库存
     */
    @Deprecated
    @GetMapping("/products/{productId}/inventory/{checkNumber}")
    Product checkProductInventory(@PathVariable("productId") Long productId,
                                  @PathVariable("checkNumber") Integer checkNumber);

    /**
     * 增加商品库存
     * 乐观锁实现
     */
    @PatchMapping("/products/{productId}/inventory/{number}")
    void updateProductInventory(@PathVariable("productId") Long productId,
                                @PathVariable("number") Integer number);
}
