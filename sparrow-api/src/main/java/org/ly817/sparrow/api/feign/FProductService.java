package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.IProductService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by LuoYu on 2019/10/27.
 */
@FeignClient(value = "sparrow-ms-product")
public interface FProductService extends IProductService {
}
