package org.ly817.sparrow.gateway.auth;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.fegin.FAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LY
 * @date 2019/09/24 17:07
 * <p>
 * Description:
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private FAdminService fAdminService;

    /**
     * 过滤器添加的时机
     * PRE_TYPE:路由前
     * ROUTING_TYPE:
     * POST_TYPE:路由后
     * ERROR_TYPE:发送错误
     *
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤链上的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否进入过滤器
     * 可以从外部读取配置
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        // 获取header中的用户名和token 调用admin微服务进行校验
        String authKey = request.getHeader("authKey");
        String[] authKeys = authKey.split(" ");
        String userName = authKeys[0];
        String token = authKeys[1];
        try {
            fAdminService.auth(userName,token);
        } catch (APIException e) {
            e.printStackTrace();
        }
        return null;
    }
}
