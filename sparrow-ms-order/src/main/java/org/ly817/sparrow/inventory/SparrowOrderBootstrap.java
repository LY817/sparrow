package org.ly817.sparrow.inventory;

import org.ly817.sparrow.api.service.IInventoryService;
import org.ly817.sparrow.api.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LY
 * @date 2019/08/14 16:28
 * <p>
 * Description:
 * 订单微服务
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient("name=sparrow-ms-inventory")
})
@EnableFeignClients(
        basePackageClasses = IInventoryService.class
)
public class SparrowOrderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowOrderBootstrap.class, args);
    }
}
