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

    //===========�û���ݹ���=============
    @ApiOperation(value="�û���¼", notes="�û���¼��ȡ��¼token",produces = "application/json")
    @PostMapping("/admin/login")
    AuthDTO login(@RequestParam("userName") String userName,@RequestParam("password") String password);

    @ApiOperation(value="ˢ��token", notes="ˢ��token",produces = "application/json")
    @PostMapping("/admin/refresh")
    AuthDTO refreshToken(@RequestParam("userName") String userName,@RequestParam("refreshToken") String refreshToken);

    @ApiOperation(value="token�����֤", notes="token�����֤",produces = "application/json")
    @PostMapping("/admin/auth")
    User auth(@RequestParam("token") String token);

//    @GetMapping("/{userName}")
//    User findUserByUserName(@PathVariable("userName") String userName);

    //=============��̬����ӳ�����==============
    /**
     * ��ѯ��ǰ����ӳ���ϵ
     */
    @ApiOperation(value="��ѯ��ǰ����ӳ���ϵ", notes="��ѯ��ǰ����ӳ���ϵ",produces = "application/json")
    @GetMapping("/admin/routes")
    List<GatewayApiRoute> getGatewayApiRoutes();

    /**
     * ����·��ӳ��
     */
    @ApiOperation(value="����·��ӳ��", notes="����·��ӳ��",produces = "application/json")
    @PutMapping("/admin/routes")
    GatewayApiRoute addGatewayApiRoute(@RequestBody GatewayApiRoute gatewayApiRoute);

    /**
     * �޸�·��ӳ��
     */
    @ApiOperation(value="�޸�·��ӳ��", notes="�޸�·��ӳ��",produces = "application/json")
    @PostMapping("/admin/routes")
    GatewayApiRoute updateGatewayApiRoute(@RequestBody GatewayApiRoute gatewayApiRoute);

}
