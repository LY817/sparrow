package org.ly817.sparrow.gateway.auth;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.ly817.sparrow.api.dto.APIResponse;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private IAdminService fAdminService;

    /**
     * 过滤器添加的时机
     * PRE_TYPE:路由前
     * ROUTING_TYPE:
     * POST_TYPE:路由后
     * ERROR_TYPE:发送错误
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        // 放行login和refresh
        if (uri.endsWith("login")) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // 获取header中的用户名和token 调用admin微服务进行校验
        String authKey = request.getHeader("authKey");
        String userName = "";
        try {
            if (authKey == null) {
                throw new APIException("500", "请求中没有身份验证信息");
            }
            String[] authKeys = authKey.split(" ");
            if (authKeys.length == 2) {
                userName = authKeys[0];
                String token = authKeys[1];
                fAdminService.auth(userName, token);
            } else {
                throw new APIException("500", "authKey格式不符合要求");
            }
        } catch (APIException e) {
            e.printStackTrace();
            logger.warn("身份验证失败 userName >>> {}", userName);
            // 拦截该请求，不对该请求进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(500);
            ctx.setResponseBody(APIResponse.exception(e).toString());
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
        }

        return null;
    }
}
