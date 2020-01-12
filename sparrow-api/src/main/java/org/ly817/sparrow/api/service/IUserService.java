package org.ly817.sparrow.api.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("用户服务")
@FeignClient("sparrow-ms-user")
public interface IUserService {

    /**
     * 新增用户
     * @param user
     */
    @ApiOperation(value="获取用户列表", notes="获取所有用户列表",produces = "application/json")
    @PostMapping("/users")
    User addUser(@RequestBody User user);

    /**
     * 更新用户
     * @param user
     */
    @ApiOperation(value="更新用户", notes="更新用户",produces = "application/json")
    @PatchMapping("/users")
    User updateUser(@RequestBody User user);

    /**
     * 根据用户id查询用户属性
     * @param userId 用户主键id @PathVariable注解必须在实现类中
     * @return User
     */
    @ApiOperation(value="根据用户id查询用户属性", notes="根据用户id查询用户属性",produces = "application/json")
    @GetMapping("/users/id/{userId}")
    User findUserById(@PathVariable("userId") Long userId);

    @ApiOperation(value="根据用户名查询用户属性", notes="根据用户名查询用户属性",produces = "application/json")
    @GetMapping("/users/username/{userName}")
    User findUserByName(@PathVariable("userName") String userName);

    /**
     * 根据用户名和密码查找记录
     * @param userName 用户名
     * @param pwd 密码
     * @return
     */
    @ApiOperation(value="根据用户名和密码查找记录", notes="根据用户名和密码查找记录",produces = "application/json")
    @GetMapping("/users/{userName}/{pwd}")
    User findUserByUserNameAndPwd(@PathVariable("userName") String userName,
                                  @PathVariable("pwd") String pwd);

}
