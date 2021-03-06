package org.ly817.sparrow.push;

import org.ly817.sparrow.api.service.IAdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by LuoYu on 2019/11/14.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient("name=sparrow-zuul-gateway"),
})
@EnableFeignClients(
        basePackageClasses = {
                IAdminService.class
        }
)
public class SparrowPushBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowPushBootstrap.class,args);
    }
}
