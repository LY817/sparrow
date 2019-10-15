package org.ly817.sparrow.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author LY
 * @date 2019/08/06 15:03
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableZuulProxy
@EnableScheduling
public class ZuulGatewayBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayBootstrap.class, args);
    }
}
