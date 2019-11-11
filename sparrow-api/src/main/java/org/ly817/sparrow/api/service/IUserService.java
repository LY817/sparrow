package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;

import org.ly817.sparrow.api.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author LuoYu
 * @date 2019/06/09 14:37
 * <p>
 * Description:
 * 用户服务接口
 */
@RequestMapping("/users")
public interface IUserService {

    /**
     * 新增用户
     * @param user
     */
    @PostMapping
    User addUser(@RequestBody User user);

    /**
     * 更新用户
     * @param user
     */
    @PatchMapping
    User updateUser(@RequestBody User user);

    /**
     * 根据用户id查询用户属性
     * @param userId 用户主键id @PathVariable注解必须在实现类中
     * @return User
     */
    @GetMapping("/{userId}")
    User findUserById(@PathVariable("userId") Long userId);

}
