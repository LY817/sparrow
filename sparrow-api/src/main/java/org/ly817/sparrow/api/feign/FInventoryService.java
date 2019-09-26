package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.IInventoryService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by LuoYu on 2019/8/18.
 *
 * feign的接口FXxxService不能和IXxxService合并
 * 否则创建feign客户端bean的时候，创建两个bean
 * 出现[Ambiguous mapping]异常
 */
@FeignClient(value = "sparrow-ms-inventory")
public interface FInventoryService extends IInventoryService {
}
