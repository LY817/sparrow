package org.ly817.sparrow.gateway.admin.mysql;

import org.ly817.sparrow.gateway.dao.GatewayApiRouteDao;
import org.ly817.sparrow.gateway.dynamic.IZuulRouteService;
import org.ly817.sparrow.gateway.dynamic.ZuulRouteServiceDBImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LY
 * @date 2020/01/05 21:50
 * <p>
 * Description:
 * ZuulRouteServiceDBImpl自动装配配置类
 */
@Configuration
@ConditionalOnProperty("spring.datasource.url")
@ImportAutoConfiguration(DataSourceAutoConfiguration.class)
public class ZuulRouteDBConfiguration {

    private final Logger logger = LoggerFactory.getLogger(ZuulRouteDBConfiguration.class);

    @Autowired
    private GatewayApiRouteDao gatewayApiRouteDao;

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties server;

    @Bean
    public ZuulRouteServiceDBImpl zuulRouteService() {
        logger.info("init ZuulRouteServiceDBImpl");
        return new ZuulRouteServiceDBImpl(gatewayApiRouteDao);
    }

    @Bean
    public DBDynamicRouteLocator routeLocator(){
        logger.info("init routeLocator");
        return new DBDynamicRouteLocator(this.server.getServlet().getContextPath(), this.zuulProperties);
    }
}
