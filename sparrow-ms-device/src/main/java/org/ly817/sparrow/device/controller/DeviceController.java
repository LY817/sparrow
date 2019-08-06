package org.ly817.sparrow.device.controller;

import org.ly817.sparrow.api.model.Device;
import org.ly817.sparrow.api.model.User;
import org.ly817.sparrow.api.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.io.IOException;

/**
 * @author LuoYu
 * @date 2019/06/06 9:05
 * <p>
 * Description:
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    private final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IUserService userService;
    /**
     * 注册设备
     * 微服务调用demo
     */
    @PostMapping("/register")
    public Device registerDevice(String imei,Long userId) throws IOException {
        // userId验证
        Device device = new Device();
        // 使用loadBalancerClient自定义实现服务调用
//        User user = loadBalancerClient.execute("sparrow-ms-user",instance -> {
//            String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/find/"+userId;
//            logger.error(url);
//            RestTemplate rest = new RestTemplate();
//            ResponseEntity<User> response = rest.getForEntity(url,User.class);
//            return response.getBody();
//        });
        // 添加LoadBalanced注解的RestTemplate根据服务名访问到负载均衡实例
//        User user = restTemplate.getForEntity("http://sparrow-ms-user"+"/user/find/"+userId,User.class).getBody();
        User user = userService.findUserById(userId);
        device.setUserId(user.getUserId());
        return device;
    }


}
