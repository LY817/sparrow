package org.ly817.sparrow.gateway.proxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.ly817.sparrow.gateway.auth.AuthFilter;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
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
        return null;
    }

    @Override
    public int filterOrder() {
        // 在AuthFilter验证之后
        return AuthFilter.ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        // todo 根据一个标识 是否开启动态转发
        return true;
    }

    /**
     * 添加
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String unitId = (String) request.getAttribute("unitId");
        // todo 访问配置服务 找到unitId对应的vendorCode
        // 交给ribbon 通过注册服务的metadata去找到对应的服务
        // 部署为不同的服务 项目名不同 微服务名保持相同 实现接口相同 但是接口实现内容不同
        String code = "";
        RibbonFilterContextHolder.getCurrentContext().add("vendor", code);
        return null;
    }
}
