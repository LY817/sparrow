package org.ly817.sparrow.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author LuoYu
 * @date 2019/06/05 12:45
 * <p>
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    private void test() throws IOException {
        loadBalancerClient.choose("sparrow-device");
        loadBalancerClient.execute("sparrow-device",instance -> {
            return "123";
        });
    }
}
