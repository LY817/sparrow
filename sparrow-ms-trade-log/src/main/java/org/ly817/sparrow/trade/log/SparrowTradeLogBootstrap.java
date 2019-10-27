package org.ly817.sparrow.trade.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LY
 * @date 2019/10/27 22:16
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.ly817.sparrow.trade.log.dao")
public class SparrowTradeLogBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowTradeLogBootstrap.class,args);
    }
}
