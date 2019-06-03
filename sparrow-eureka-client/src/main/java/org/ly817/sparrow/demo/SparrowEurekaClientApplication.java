package org.ly817.sparrow.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SparrowEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparrowEurekaClientApplication.class, args);
    }

}
