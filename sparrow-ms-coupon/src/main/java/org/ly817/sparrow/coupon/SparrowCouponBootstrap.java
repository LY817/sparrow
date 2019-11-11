package org.ly817.sparrow.coupon;

import org.ly817.sparrow.api.feign.FInventoryService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LY
 * @date 2019/10/30 20:57
 * <p>
 * Description:
 * 优惠券微服务
 */
@SpringBootApplication
@EnableEurekaClient
//@MapperScan("org.ly817.sparrow.coupon.dao")
//@RibbonClients({
//        @RibbonClient("name=sparrow-ms-coupon")
//})
//@EnableFeignClients(
//        basePackageClasses = {
//                FInventoryService.class
//        }
//)
public class SparrowCouponBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowCouponBootstrap.class,args);
    }
}
