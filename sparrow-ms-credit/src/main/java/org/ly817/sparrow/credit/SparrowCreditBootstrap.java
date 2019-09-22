package org.ly817.sparrow.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LY
 * @date 2019/08/14 16:28
 * <p>
 * Description:
 * 库存微服务
 */
@SpringBootApplication
@EnableEurekaClient
public class SparrowCreditBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowCreditBootstrap.class,args);
    }
}
