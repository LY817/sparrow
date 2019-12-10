package org.ly817.sparrow.admin;

import org.ly817.sparrow.api.feign.FUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LY
 * @date 2019/09/23 12:44
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient("name=sparrow-ms-user")
})
@EnableFeignClients(
        basePackageClasses = {
                FUserService.class
        }
)
public class SparrowAdminBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowAdminBootstrap.class,args);
    }
}
