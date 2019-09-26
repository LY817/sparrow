package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.IAdminService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by LuoYu on 2019/9/24.
 */
@FeignClient(value = "sparrow-ms-admin")
public interface FAdminService extends IAdminService {
}
