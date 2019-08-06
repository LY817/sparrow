package org.ly817.sparrow.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author LY
 * @date 2019/08/06 15:03
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayBootstrap.class, args);
    }
}
