package org.ly817.sparrow.gateway.dynamic;

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
public abstract class AbstractDynamicRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private final Logger logger = LoggerFactory.getLogger(AbstractDynamicRouteLocator.class);

    private Boolean firstFlag = true;

    private int invokeTimes = 0;

    private ZuulProperties properties;

    public AbstractDynamicRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.properties = properties;
    }

    /**
     * refreshRoute事件触发属性路由列表
     */
    @Override
    public void refresh() {
        logger.info("触发第{}次",invokeTimes);
        invokeTimes ++;

        doRefresh();
    }

    /**
     * 重写地址路由逻辑
     * doRefresh方法调用locateRoutes
     */
    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        // super.locateRoutes() 加载application.yml中zuul.routes.xxx配置
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
//        routesMap.putAll(super.locateRoutes());
        if (!firstFlag) {
            routesMap = loadDynamicRoutes();
        }
        if (firstFlag) {
            firstFlag = false;
        }
        // 统一处理路由path的格式 必须以“/”开头
        Map<String, ZuulProperties.ZuulRoute> values = super.locateRoutes();
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

    /**
     * 加载外部数据为Zuul网关的路由数据
     */
    public abstract LinkedHashMap<String, ZuulProperties.ZuulRoute> loadDynamicRoutes();
//    private LinkedHashMap<String, ZuulProperties.ZuulRoute> loadDynamicRoutes(){
//        logger.info("触发第{}次",invokeTimes);
//        LinkedHashMap<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
//        List<GatewayApiRoute> results = null;
//        for (GatewayApiRoute result : results) {
//            if (StringUtils.isEmpty(result.getPath()) ) {
//                continue;
//            }
//            if (StringUtils.isEmpty(result.getServiceId())
//                    && StringUtils.isEmpty(result.getUrl())) {
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
//        return routes;
//    }
}
