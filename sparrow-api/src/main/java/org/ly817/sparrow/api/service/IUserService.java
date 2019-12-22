package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;

import org.ly817.sparrow.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author LuoYu
 * @date 2019/06/09 14:37
 * <p>
 * Description:
 * 用户服务接口
 */
//@RequestMapping("/users")
@FeignClient("sparrow-ms-user")
public interface IUserService {

    /**
     * 新增用户
     * @param user
     */
    @PostMapping("/users")
    User addUser(@RequestBody User user);

    /**
     * 更新用户
     * @param user
     */
    @PatchMapping("/users")
    User updateUser(@RequestBody User user);

    /**
     * 根据用户id查询用户属性
     * @param userId 用户主键id @PathVariable注解必须在实现类中
     * @return User
     */
    @GetMapping("/users/{userId}")
    User findUserById(@PathVariable("userId") Long userId);

    @GetMapping("/users/{userName}")
    User findUserByName(@PathVariable("userName") String userName);

    /**
     * 根据用户名和密码查找记录
     * @param userName 用户名
     * @param pwd 密码
     * @return
     */
    @GetMapping("/users/{userName}/{pwd}")
    User findUserByUserNameAndPwd(@PathVariable("userName") String userName,
                                  @PathVariable("pwd") String pwd);

}
