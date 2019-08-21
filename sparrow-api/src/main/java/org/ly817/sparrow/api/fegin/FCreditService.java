package org.ly817.sparrow.api.fegin;

import org.ly817.sparrow.api.service.ICreditService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author LY
 * @date 2019/08/21 16:34
 * <p>
 * Description:
 * 积分服务 feign接口
 */
@FeignClient(value = "sparrow-ms-pay")
public interface FCreditService extends ICreditService {
}
