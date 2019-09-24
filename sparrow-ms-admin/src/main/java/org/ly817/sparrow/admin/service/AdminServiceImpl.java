package org.ly817.sparrow.admin.service;

import org.ly817.sparrow.admin.dao.UserMapper;
import org.ly817.sparrow.api.dto.AuthDTO;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.User;
import org.ly817.sparrow.api.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author LY
 * @date 2019/09/24 10:13
 * <p>
 * Description:
 */
@RestController
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public AuthDTO login(@RequestParam("userName") String userName,
                         @RequestParam("password") String password) {
        User existUser = userMapper.findUserByUserNameAndPwd(userName,password);
        AuthDTO authDTO = new AuthDTO();
        if (existUser != null) {
            String authKey = "AUTH_" + existUser.getUserName();
            String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
            String refreshToken = UUID.randomUUID().toString().replaceAll("-", "");
            redisTemplate.opsForHash().put(authKey,accessToken,existUser);
            redisTemplate.opsForHash().put(authKey,refreshToken,accessToken);
            redisTemplate.expire(authKey,authDTO.getExpireIn(),TimeUnit.SECONDS);
            authDTO.setAuthFlag(true);
            authDTO.setAccessToken(accessToken);
            authDTO.setRefreshToken(refreshToken);
        } else {
            authDTO.setAuthFlag(false);
        }
        return authDTO;
    }

    @Override
    public AuthDTO refreshToken(String userName,String refreshToken) {

        return null;
    }

    @Override
    public User auth(String userName,String token) throws APIException {
        String authKey = "AUTH_" + userName;
        User user = (User) redisTemplate.opsForHash().get(authKey,token);
        if (user != null) {
            return user;
        } else {
            throw new APIException("408","鉴权失败");
        }
    }

    @Override
    public User findUserByUserName(@PathVariable("userName") String userName) {
        return userMapper.findUserByUsername(userName);
    }
}
