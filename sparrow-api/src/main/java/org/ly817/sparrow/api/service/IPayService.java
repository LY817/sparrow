package org.ly817.sparrow.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 * 支付接口
 */
@FeignClient(value = "sparrow-ms-pay")
@RequestMapping("sparrow-ms-pay")
public interface IPayService {
}
