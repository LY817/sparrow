package org.ly817.sparrow.gateway.gray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 自定义路由策略
 */
//@Configuration
public class DynamicRouteConfiguration {
 
//    @Autowired
    private ZuulProperties zuulProperties;

//    @Autowired
    private ServerProperties server;

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
 
//    @Bean
    public DynamicRouteLocator routeLocator() {
    	DynamicRouteLocator routeLocator = new DynamicRouteLocator(
    			this.server.getServlet().getContextPath(), this.zuulProperties);
//        routeLocator.setJdbcTemplate(jdbcTemplate);
        return routeLocator;
    }
 
}