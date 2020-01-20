package org.ly817.sparrow.gateway.proxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.ly817.sparrow.gateway.auth.AuthFilter;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LY
 * @date 2020/01/19 22:20
 * <p>
 * Description:
 * 根据身份验证转发转发到不同的服务地址上
 */
@Component
public class DynamicProxyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 在AuthFilter验证之后
        return AuthFilter.ORDER + 1;
    }

    /**
     * 对某些请求进行动态转发
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        return true;
    }

    /**
     * 根据身份对应的类型
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Long userId = (Long) request.getAttribute("userId");
        // todo 访问配置服务 找到unitId对应的vendorCode
        // 交给ribbon 通过注册服务的metadata去找到对应的服务
        // 部署为不同的服务 项目名不同 微服务名保持相同 实现接口相同 但是接口实现内容不同
        String code = "";
        if (373657843720654848L == userId) {
            code = "stark";
        }
        if (376206293658112000L == userId) {
            code = "hik";
        }
        RibbonFilterContextHolder.getCurrentContext().add("vendor", code);
        // 返回值被忽略
        return null;
    }
}
