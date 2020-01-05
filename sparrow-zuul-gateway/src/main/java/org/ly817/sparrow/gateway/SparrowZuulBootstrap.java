package org.ly817.sparrow.gateway;


import org.ly817.sparrow.api.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LY
 * @date 2019/09/21 14:31
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableZuulProxy
@RibbonClients({
        @RibbonClient("name=sparrow-ms-user")
})
@EnableFeignClients(
        basePackageClasses = {
                IUserService.class
        }
)
public class SparrowZuulBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowZuulBootstrap.class,args);
    }
}
