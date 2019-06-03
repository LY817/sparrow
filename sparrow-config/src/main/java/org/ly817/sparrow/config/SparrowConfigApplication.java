package org.ly817.sparrow.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LuoYu
 * @date 2019/06/03 11:01
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class SparrowConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparrowConfigApplication.class,args);
    }
}
