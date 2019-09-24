package org.ly817.sparrow.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LY
 * @date 2019/09/23 12:44
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.ly817.sparrow.admin.dao")
public class SparrowAdminBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowAdminBootstrap.class,args);
    }
}
