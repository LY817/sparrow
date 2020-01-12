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
 * �û�����ӿ�
 */
@Api("�û�����")
@FeignClient("sparrow-ms-user")
public interface IUserService {

    /**
     * �����û�
     * @param user
     */
    @ApiOperation(value="��ȡ�û��б�", notes="��ȡ�����û��б�",produces = "application/json")
    @PostMapping("/users")
    User addUser(@RequestBody User user);

    /**
     * �����û�
     * @param user
     */
    @ApiOperation(value="�����û�", notes="�����û�",produces = "application/json")
    @PatchMapping("/users")
    User updateUser(@RequestBody User user);

    /**
     * �����û�id��ѯ�û�����
     * @param userId �û�����id @PathVariableע�������ʵ������
     * @return User
     */
    @ApiOperation(value="�����û�id��ѯ�û�����", notes="�����û�id��ѯ�û�����",produces = "application/json")
    @GetMapping("/users/id/{userId}")
    User findUserById(@PathVariable("userId") Long userId);

    @ApiOperation(value="�����û�����ѯ�û�����", notes="�����û�����ѯ�û�����",produces = "application/json")
    @GetMapping("/users/username/{userName}")
    User findUserByName(@PathVariable("userName") String userName);

    /**
     * �����û�����������Ҽ�¼
     * @param userName �û���
     * @param pwd ����
     * @return
     */
    @ApiOperation(value="�����û�����������Ҽ�¼", notes="�����û�����������Ҽ�¼",produces = "application/json")
    @GetMapping("/users/{userName}/{pwd}")
    User findUserByUserNameAndPwd(@PathVariable("userName") String userName,
                                  @PathVariable("pwd") String pwd);

}
