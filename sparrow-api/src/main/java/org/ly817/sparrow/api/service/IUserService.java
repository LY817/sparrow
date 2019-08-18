package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LuoYu
 * @date 2019/06/09 14:37
 * <p>
 * Description:
 * 用户服务接口
 */
@RequestMapping("user")
public interface IUserService {

    /**
     * 根据用户id查询用户属性
     * @param userId 用户主键id @PathVariable注解必须在实现类中
     * @return User
     */
    @GetMapping("/user/{userId}")
    User findUserById(Long userId) throws APIException;

}
