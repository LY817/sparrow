package org.ly817.sparrow.order;

import org.ly817.sparrow.api.feign.FInventoryService;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("org.ly817.sparrow.order.dao")
@RibbonClients({
        @RibbonClient("name=sparrow-ms-inventory")
})
@EnableFeignClients(
        basePackageClasses = {
                FInventoryService.class
        }
)
public class SparrowOrderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowOrderBootstrap.class, args);
    }
}
