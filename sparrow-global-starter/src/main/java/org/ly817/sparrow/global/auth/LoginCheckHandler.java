package org.ly817.sparrow.global.auth;

import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.ly817.sparrow.api.dto.APIResponse;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author LY
 * @date 2020/01/12 20:05
 * <p>
 * Description:
 * 登录状态检查拦截器
 */
@Aspect
@Component
@DependsOn("jwtOperator")
public class LoginCheckHandler {

    private final Logger logger = LoggerFactory.getLogger(LoginCheckHandler.class);

    @Autowired
    public JwtOperator jwtOperator;

    @Around("@annotation(org.ly817.sparrow.global.auth.CheckLogin)")
    public Object checkLoginStatus(ProceedingJoinPoint point) throws Throwable {
        // RequestContextHolder 静态方法访问ThreadLocal变量
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (!ObjectUtils.isEmpty(requestAttributes)) {
            HttpServletRequest request = requestAttributes.getRequest();
            String token = request.getHeader("token");
            if (!StringUtils.isEmpty(token)) {
                if (jwtOperator.validateToken(token)) {
                    Claims claims = jwtOperator.getClaimsFromToken(token);
                    Long userId = claims.get("userId",Long.class);
                    request.setAttribute("userId",userId);
                    return point.proceed();
                } else {
                    throw new APIException(APIExceptionType.AUTH_FAILED);
                }
            } else {
                throw new APIException(APIExceptionType.AUTH_FAILED);
            }
        } else {
            throw new APIException(APIExceptionType.AUTH_FAILED);
        }
    }
}
