package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.IUserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by LuoYu on 2019/11/3.
 */
@FeignClient("sparrow-ms-user")
public interface FUserService extends IUserService {
}
