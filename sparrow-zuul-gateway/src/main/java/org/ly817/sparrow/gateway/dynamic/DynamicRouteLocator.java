package org.ly817.sparrow.gateway.dynamic;

import org.ly817.sparrow.api.feign.FAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LY
 * @date 2019/09/27 15:49
 * <p>
 * Description:
 */
public class DynamicRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private final Logger logger = LoggerFactory.getLogger(DynamicRouteLocator.class);

    private static boolean firstFlag = true;

    private FAdminService fAdminService;

    private ZuulProperties properties;

    public DynamicRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.properties = properties;
    }

    public FAdminService getfAdminService() {
        return fAdminService;
    }

    public void setfAdminService(FAdminService fAdminService) {
        this.fAdminService = fAdminService;
    }

    /**
     * 触发refreshRoute事件
     */
    @Override
    public void refresh() {
        logger.info("定时触发");
        doRefresh();
    }

    /**
     * 重写地址路由逻辑
     * 首次加载时，将配置文件中的路由表更新到admin/route服务
     */
    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        // 加载application.yml中的路由表
        routesMap.putAll(super.locateRoutes());
        if (firstFlag) {
            // 首次加载时，将配置文件中的路由表更新到admin/route服务

            firstFlag = false;
        } else {
            // 非首次加载，获取redis中修改后的路由信息

        }


        // 统一处理路由path的格式
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }

        return values;
    }

    private Map<String, ZuulProperties.ZuulRoute> loadDynamicRoutes(){
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();


//        for (GatewayApiRoute result : results) {
//            if (StringUtils.isEmpty(result.getPath()) ) {
//                continue;
//            }
//            if (StringUtils.isEmpty(result.getServiceId()) && StringUtils.isEmpty(result.getUrl())) {
//                continue;
//            }
//            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
//            try {
//                BeanUtils.copyProperties(result, zuulRoute);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            routes.put(zuulRoute.getPath(), zuulRoute);
//        }

        return routes;
    }
}
