package org.ly817.sparrow.global.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.ly817.sparrow.api.exception.APIException;
import org.springframework.context.annotation.Configuration;

/**
 * @author LY
 * @date 2019/08/19 16:35
 * <p>
 * Description:
 * feign调用异常解析
 */
@Configuration
public class FeignExceptionDecoder implements ErrorDecoder {
    /**
     *
     * @param methodKey
     * @param response 获取返回值 如果
     * @return
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            if (response.body() != null) {
                JSONObject apiResponseJson = JSON.parseObject(Util.toString(response.body().asReader()));
                if (!"200".equals(apiResponseJson.getString("code"))) {
                    return new APIException(apiResponseJson.getString("msg")
                                            ,apiResponseJson.getString("code"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FeignException.errorStatus(methodKey, response);
    }
}
