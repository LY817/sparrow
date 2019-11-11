package org.ly817.sparrow.api.feign;

import org.ly817.sparrow.api.service.ICouponService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by LuoYu on 2019/10/30.
 */
@FeignClient(value = "sparrow-ms-coupon")
public interface FCouponService extends ICouponService {
}
