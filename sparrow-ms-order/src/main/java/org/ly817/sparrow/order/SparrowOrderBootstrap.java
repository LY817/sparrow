package org.ly817.sparrow.order;

import org.ly817.sparrow.api.fegin.FCreditService;
import org.ly817.sparrow.api.fegin.FInventoryService;
import org.ly817.sparrow.api.fegin.FPayService;
import org.ly817.sparrow.api.service.IInventoryService;
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
        @RibbonClient("name=sparrow-ms-inventory"),
        @RibbonClient("name=sparrow-ms-pay"),
        @RibbonClient("name=sparrow-ms-credit")
})
@EnableFeignClients(
        basePackageClasses = {
                FInventoryService.class,
                FPayService.class,
                FCreditService.class
        }
)
public class SparrowOrderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowOrderBootstrap.class, args);
    }
}
