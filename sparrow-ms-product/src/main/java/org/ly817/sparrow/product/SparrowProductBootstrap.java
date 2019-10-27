package org.ly817.sparrow.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LY
 * @date 2019/10/27 16:26
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.ly817.sparrow.product.dao")
public class SparrowProductBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowProductBootstrap.class,args);
    }
}
