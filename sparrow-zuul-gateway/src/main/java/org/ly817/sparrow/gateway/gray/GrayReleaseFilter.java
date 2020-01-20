package org.ly817.sparrow.gateway.gray;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author LY
 * @date 2020/01/20 19:25
 * <p>
 * Description:
 * 灰度发布过滤器
 *
 */
@Component
public class GrayReleaseFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(GrayReleaseFilter.class);

    ThreadLocal<Integer> currentPercent = new ThreadLocal<>();

    AntPathMatcher matcher = new AntPathMatcher();

    Random random = new Random();

    /**
     * url地址获取工具类
     */
    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    /**
     * 拦截规则
     * 从公共存储中读取需要拦截的服务路径
     * 服务描述
     * - 服务匹配路径 /user/users
     * - 服务请求方法 GET/POST/...
     * - 分流流量比例 1-100整数
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        request.getMethod();
        String uri = urlPathHelper.getRequestUri(request);
        String lookUpUrl = urlPathHelper.getLookupPathForRequest(request);
        // lookUpUrl遍历匹配存储中配置的路径表达式
        // 匹配通过返回true

        currentPercent.set(2);

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        Integer percent = currentPercent.get();
        if (ObjectUtils.isEmpty(percent)) {
            percent = 1;
        }
        int sed = random.nextInt(100);
        if (sed > 0 && sed <= percent) {
            logger.info("invoke gray release version");
            RibbonFilterContextHolder.getCurrentContext().add("version", "");
        } else {
            logger.info("invoke old release version");
            RibbonFilterContextHolder.getCurrentContext().add("version", "");
        }

        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 99999;
    }
}
