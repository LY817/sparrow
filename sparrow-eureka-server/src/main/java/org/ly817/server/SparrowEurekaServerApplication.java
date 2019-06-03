package org.ly817.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SparrowEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparrowEurekaServerApplication.class, args);
    }

}
