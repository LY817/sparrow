package org.ly817.sparrow.order;


import com.netflix.loadbalancer.RandomRule;
import org.ly817.sparrow.api.service.ICouponService;
import org.ly817.sparrow.api.service.IProductService;
import org.ly817.sparrow.api.service.ITradeLogService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LY
 * @date 2019/08/14 16:28
 * <p>
 * Description:
 * 订单微服务
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.ly817.sparrow.order.dao")
@RibbonClients({
        @RibbonClient("name=sparrow-ms-product"),
        @RibbonClient("name=sparrow-ms-coupon"),
        @RibbonClient(value = "name=sparrow-ms-trade-log",configuration = RandomRule.class),
})
@EnableFeignClients(
        basePackageClasses = {
                IProductService.class,
                ICouponService.class,
                ITradeLogService.class,
        }
)
public class SparrowOrderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SparrowOrderBootstrap.class, args);
    }
}
