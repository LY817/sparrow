package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.ITradeLogService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author LY
 * @date 2019/11/10 19:09
 * <p>
 * Description:
 */
@FeignClient(value = "sparrow-ms-trade-log")
public interface FTradeLogService extends ITradeLogService {
}
