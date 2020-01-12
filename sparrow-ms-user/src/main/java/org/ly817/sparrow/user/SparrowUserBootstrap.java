package org.ly817.sparrow.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
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
@EnableHystrix
public class SparrowUserBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SparrowUserBootstrap.class,args);
        System.out.println(context);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
