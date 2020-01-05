package org.ly817.sparrow.gateway.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author LY
 * @date 2019/09/27 16:00
 * <p>
 * Description:
 * 定时通知zuul更新路由地址
 * zuul自己会30s刷新一次路由信息
 */
//@Component
//@Configuration
//@EnableScheduling
@Deprecated
public class DynamicRefreshRouteTask {

    /**
     * 利用Spring中的事件机制解耦
     * 通知zuul更新路由地址
     */
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private RouteLocator routeLocator;

//    @Scheduled(fixedRate = 1000000)
    private void refreshRoute() {
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }
}
