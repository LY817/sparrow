package org.ly817.sparrow.device;

import org.ly817.sparrow.api.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author LuoYu
 * @date 2019/06/05 17:07
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient("name=sparrow-ms-user")
})
//@EnableCircuitBreaker // 短路
@EnableFeignClients(
        basePackageClasses = IUserService.class
)
public class SparrowDeviceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowDeviceBootstrap.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
