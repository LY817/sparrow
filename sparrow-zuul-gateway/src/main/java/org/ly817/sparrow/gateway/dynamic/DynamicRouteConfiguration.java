package org.ly817.sparrow.gateway.dynamic;

import org.ly817.sparrow.api.feign.FAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LY
 * @date 2019/09/27 15:47
 * <p>
 * Description:
 * 自定义路由策略
 */
@Configuration
public class DynamicRouteConfiguration {


    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties server;

    @Autowired
    private FAdminService fAdminService;

    @Bean
    public DynamicRouteLocator routeLocator() {
        DynamicRouteLocator routeLocator = new DynamicRouteLocator(
                this.server.getServlet().getContextPath(), this.zuulProperties);
        routeLocator.setfAdminService(fAdminService);
        return routeLocator;
    }
}
