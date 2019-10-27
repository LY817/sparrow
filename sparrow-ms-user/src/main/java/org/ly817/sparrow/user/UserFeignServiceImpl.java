package org.ly817.sparrow.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.ly817.sparrow.api.model.User;
import org.ly817.sparrow.api.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author LuoYu
 * @date 2019/06/09 14:39
 * <p>
 * Description:
 */
@RestController
//@RequestMapping("/user")
// 为feign调用提供服务时 不使用RequestMapping设置访问路径 与feign客户端接口实现保存一致
// 所有规约有共同继承的接口控制
public class UserFeignServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserFeignServiceImpl.class);

    @Override
    @HystrixCommand(
        commandProperties = {
                // 超时时间为100ms
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
        },
        fallbackMethod = "fbFindUserById"
    )
    public User findUserById(@PathVariable Long userId) {
        User user = new User();
        if (userId == 1000L) {
            user.setUserId(userId+"");
            user.setUserName("luoyu");
            user.setPassword("luoyu666");
        }
        // 超时容错
        Random random = new Random();
        long execTime = random.nextInt(200);
        logger.error(execTime + "");
        try {
            Thread.sleep(execTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }


    // ==============Hystrix fallback methods===============
    public User fbFindUserById(Long userId){
        User user = new User();
        user.setUserId(666L+"");
        user.setUserName("备胎");
        user.setPassword("sdadeqare");
        return user;
    }
}
