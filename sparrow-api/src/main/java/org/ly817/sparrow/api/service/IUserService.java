package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LuoYu
 * @date 2019/06/09 14:37
 * <p>
 * Description:
 * 用户服务接口
 */
@FeignClient(value = "sparrow-ms-user")
public interface IUserService {

    /**
     * 根据用户id查询用户属性
     * @param userId 用户主键id
     * @return User
     */
    @GetMapping("/user/{userId}")
    User findUserById(Long userId);

}
