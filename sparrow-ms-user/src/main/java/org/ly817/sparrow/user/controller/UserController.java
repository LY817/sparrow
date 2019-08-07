package org.ly817.sparrow.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.ly817.sparrow.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * @author LuoYu
 * @date 2019/06/05 12:45
 * <p>
 * Description:
 *
 * update 服务提供方和消费方feign是用同一个接口
 * 公用接口 @see org.ly817.sparrow.api.service.IUserService
 * 服务提供者实现 @see org.ly817.sparrow.user.service.UserFeignServiceImpl
 */
@Deprecated
@RestController
//@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/add")
    public User addUser(User user){
        return null;
    }

    @GetMapping("/find/{userId}")
    @HystrixCommand(
        commandProperties = {
            // 超时时间为100ms
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
        },
        fallbackMethod = "fallBackFindUser"
    )
    public User findUserById(@PathVariable Long userId) throws InterruptedException {
        User user = new User();
        if (userId == 1000L) {
            user.setUserId(1000L);
            user.setUserName("luoyu");
            user.setPassword("luoyu666");
        }
        // 超时容错
        Random random = new Random();
        long execTime = random.nextInt(200);
        logger.error(execTime + "");
        Thread.sleep(execTime);
        return user;
    }

    /**
     * fallbackMethod方法与原方法
     */
    public User fallBackFindUser(Long userId){
        User user = new User();
        user.setUserName("back");
        user.setUserId(0L);
        return user;
    }
}
