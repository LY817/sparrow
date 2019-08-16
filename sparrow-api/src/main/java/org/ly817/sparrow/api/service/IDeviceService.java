package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Device;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LY
 * @date 2019/08/07 10:42
 * <p>
 * Description:
 * 设备微服务接口
 */
@FeignClient(value = "sparrow-ms-device")
@RequestMapping("sparrow-ms-device")
public interface IDeviceService {

    @GetMapping("/register/{imei}/{userId}")
    Device registerDevice(String imei, Long userId) throws APIException;

}
