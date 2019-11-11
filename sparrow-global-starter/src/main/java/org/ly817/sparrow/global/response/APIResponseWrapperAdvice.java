package org.ly817.sparrow.global.response;


import org.ly817.sparrow.api.dto.APIResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author LY
 * @date 2019/09/24 15:54
 * <p>
 * Description:
 * 按正常逻辑（没有抛异常）返回的对象
 * 统一异常 将内置异常转成APIException
 */
//@ControllerAdvice
//@ResponseBody
@Deprecated
public class APIResponseWrapperAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        String url = request.getURI().getPath();
        // todo 处理特殊路径，不需要做包装
        // 如果匹配到了完全不包装的url，直接返回
        Object result;
        if (body instanceof APIResponse) {
            result = body;
        } else {
            // 其他类型进行统一包装
            result = APIResponse.success(body);

        }
        return result;
    }
}
