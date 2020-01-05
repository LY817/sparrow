package org.ly817.sparrow.gateway.admin.mysql;

import org.ly817.sparrow.gateway.dynamic.AbstractDynamicRouteLocator;
import org.ly817.sparrow.gateway.dynamic.ZuulRouteServiceDBImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.LinkedHashMap;

/**
 * @author LY
 * @date 2020/01/05 22:10
 * <p>
 * Description:
 */
public class DBDynamicRouteLocator extends AbstractDynamicRouteLocator {

    @Autowired
    private ZuulRouteServiceDBImpl zuulRouteService;


    public DBDynamicRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    public LinkedHashMap<String, ZuulProperties.ZuulRoute> loadDynamicRoutes() {
        return null;
    }
}
