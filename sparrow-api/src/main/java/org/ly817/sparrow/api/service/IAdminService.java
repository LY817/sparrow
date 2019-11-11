package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.dto.AuthDTO;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LuoYu on 2019/9/24.
 */
@RequestMapping("admin")
public interface IAdminService {

    //===========用户身份管理=============

    @PostMapping("/user/login")
    AuthDTO login(@RequestParam("userName") String userName,@RequestParam("password") String password);

    @PostMapping("/user/refresh")
    AuthDTO refreshToken(@RequestParam("userName") String userName,@RequestParam("refreshToken") String refreshToken);

    @PostMapping("/user/auth")
    User auth(@RequestParam("userName") String userName,@RequestParam("token") String token);

    @GetMapping("/user/{userName}")
    User findUserByUserName(@PathVariable("userName") String userName);

    //=============动态网关映射管理==============

    /**
     * 查询当前服务映射关系
     */


}
