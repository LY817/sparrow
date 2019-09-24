package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.dto.AuthDTO;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/9/24.
 */
@RequestMapping("admin")
public interface IAdminService {

    //===========用户省份管理=============

    @PostMapping("/user/login")
    AuthDTO login(String userName, String password);

    @PostMapping("/user/refresh")
    AuthDTO refreshToken(String userName,String refreshToken);

    @PostMapping("/user/auth")
    User auth(String userName,String token) throws APIException;

    @GetMapping("/user/{userName}")
    User findUserByUserName(String userName);

    //=============动态网关映射管理==============
}
