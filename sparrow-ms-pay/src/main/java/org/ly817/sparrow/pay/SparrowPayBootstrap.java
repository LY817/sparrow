package org.ly817.sparrow.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LY
 * @date 2019/08/21 16:14
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class SparrowPayBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowPayBootstrap.class, args);
    }
}
