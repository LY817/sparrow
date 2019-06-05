package org.ly817.sparrow.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author LuoYu
 * @date 2019/06/05 11:00
 * <p>
 * Description:
 * 用户微服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient("name=sparrow-ms-device")
})
public class SparrowUserBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowUserBootstrap.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
