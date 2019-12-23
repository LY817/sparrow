package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.dto.AuthDTO;
import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LuoYu on 2019/9/24.
 */
//@RequestMapping
@FeignClient("sparrow-ms-admin")
public interface IAdminService {

    //===========用户身份管理=============

    @PostMapping("/admin/login")
    AuthDTO login(@RequestParam("userName") String userName,@RequestParam("password") String password);

    @PostMapping("/admin/refresh")
    AuthDTO refreshToken(@RequestParam("userName") String userName,@RequestParam("refreshToken") String refreshToken);

    @PostMapping("/admin/auth")
    User auth(@RequestParam("userName") String userName,@RequestParam("token") String token);

//    @GetMapping("/{userName}")
//    User findUserByUserName(@PathVariable("userName") String userName);

    //=============动态网关映射管理==============
    /**
     * 查询当前服务映射关系
     */
    @GetMapping("/admin/routes")
    List<GatewayApiRoute> getGatewayApiRoutes();

    /**
     * 新增路由映射
     */
    @PutMapping("/admin/routes")
    GatewayApiRoute addGatewayApiRoute(@RequestBody GatewayApiRoute gatewayApiRoute);

    /**
     * 修改路由映射
     */
    @PostMapping("/admin/routes")
    GatewayApiRoute updateGatewayApiRoute(@RequestBody GatewayApiRoute gatewayApiRoute);

}
