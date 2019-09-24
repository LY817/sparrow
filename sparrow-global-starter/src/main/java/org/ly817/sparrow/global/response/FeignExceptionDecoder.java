package org.ly817.sparrow.global.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.ly817.sparrow.api.exception.APIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author LY
 * @date 2019/08/19 16:35
 * <p>
 * Description:
 * feign调用异常解析
 * Error Decoders are invoked only when a response is received and the response code is not 2xx
 * 只有当http响应状态码不是2xx才会进行解析
 */
@Configuration
public class FeignExceptionDecoder implements ErrorDecoder {

    private final Logger logger = LoggerFactory.getLogger(FeignExceptionDecoder.class);
    /**
     *
     * @param methodKey
     * @param response 获取返回值 如果
     * @return
     */
    @Override
    public APIException decode(String methodKey, Response response) {
        try {
            if (response.body() != null) {
                JSONObject apiResponseJson = JSON.parseObject(Util.toString(response.body().asReader()));
                if (!"200".equals(apiResponseJson.getString("code"))) {
                    return new APIException(apiResponseJson.getString("code"),
                                            apiResponseJson.getString("msg"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.error("出现未知异常 调用地址：{}",methodKey);
        return new APIException("未知异常 请联系管理员 调用地址：" + methodKey,"666");
    }
}
