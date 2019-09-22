package org.ly817.sparrow.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author LY
 * @date 2019/09/21 14:31
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableZuulProxy
public class SparrowZuulBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowZuulBootstrap.class,args);
    }
}
