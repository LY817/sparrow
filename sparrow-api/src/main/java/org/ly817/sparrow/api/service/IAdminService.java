package org.ly817.sparrow.api.service;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="用户登录", notes="用户登录获取登录token",produces = "application/json")
    @PostMapping("/admin/login")
    AuthDTO login(@RequestParam("userName") String userName,@RequestParam("password") String password);

    @ApiOperation(value="刷新token", notes="刷新token",produces = "application/json")
    @PostMapping("/admin/refresh")
    AuthDTO refreshToken(@RequestParam("userName") String userName,@RequestParam("refreshToken") String refreshToken);

    @ApiOperation(value="token身份验证", notes="token身份验证",produces = "application/json")
    @PostMapping("/admin/auth")
    User auth(@RequestParam("token") String token);

//    @GetMapping("/{userName}")
//    User findUserByUserName(@PathVariable("userName") String userName);

    //=============动态网关映射管理==============
    /**
     * 查询当前服务映射关系
     */
    @ApiOperation(value="查询当前服务映射关系", notes="查询当前服务映射关系",produces = "application/json")
    @GetMapping("/admin/routes")
    List<GatewayApiRoute> getGatewayApiRoutes();

    /**
     * 新增路由映射
     */
    @ApiOperation(value="新增路由映射", notes="新增路由映射",produces = "application/json")
    @PutMapping("/admin/routes")
    GatewayApiRoute addGatewayApiRoute(@RequestBody GatewayApiRoute gatewayApiRoute);

    /**
     * 修改路由映射
     */
    @ApiOperation(value="修改路由映射", notes="修改路由映射",produces = "application/json")
    @PostMapping("/admin/routes")
    GatewayApiRoute updateGatewayApiRoute(@RequestBody GatewayApiRoute gatewayApiRoute);

}
