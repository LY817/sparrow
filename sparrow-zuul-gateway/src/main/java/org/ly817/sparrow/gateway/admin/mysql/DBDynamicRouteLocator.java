package org.ly817.sparrow.gateway.admin.mysql;

import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.gateway.dynamic.AbstractDynamicRouteLocator;
import org.ly817.sparrow.gateway.dynamic.ZuulRouteServiceDBImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;

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

    /**
     * 从数据库中读取路由信息
     *
     */
    @Override
    public LinkedHashMap<String, ZuulProperties.ZuulRoute> loadDynamicRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        List<GatewayApiRoute> results = zuulRouteService.listAll();
        for (GatewayApiRoute result : results) {
            if (StringUtils.isEmpty(result.getPath()) ) {
                continue;
            }
            if (StringUtils.isEmpty(result.getServiceId())
                    && StringUtils.isEmpty(result.getUrl())) {
                continue;
            }
            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
            try {
                BeanUtils.copyProperties(result, zuulRoute);
            } catch (Exception e) {
                e.printStackTrace();
            }
            routes.put(zuulRoute.getPath(), zuulRoute);
        }
        return routes;
    }
}
