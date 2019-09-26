package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.IPayService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author LY
 * @date 2019/08/21 16:31
 * <p>
 * Description:
 * 支付服务 feign接口
 */
@FeignClient(value = "sparrow-ms-pay")
public interface FPayService extends IPayService {
}
