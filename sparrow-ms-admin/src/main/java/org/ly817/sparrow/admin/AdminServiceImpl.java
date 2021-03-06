package org.ly817.sparrow.admin;

import org.ly817.sparrow.admin.dao.GatewayApiRouteDao;
import org.ly817.sparrow.api.dto.AuthDTO;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;

import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.api.pojo.GatewayApiRouteExample;
import org.ly817.sparrow.api.pojo.User;
import org.ly817.sparrow.api.service.IAdminService;
import org.ly817.sparrow.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    RedisTemplate redisTemplate;

    @Autowired
    private IUserService fUserService;

    @Autowired
    private GatewayApiRouteDao gatewayApiRouteDao;


    @Override
    public AuthDTO login(@RequestParam("userName") String userName,
                         @RequestParam("password") String password) {
        User existUser = fUserService.findUserByUserNameAndPwd(userName,password);
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
            throw new APIException(APIExceptionType.AUTH_FAILED);
        }
        return authDTO;
    }

    @Override
    public AuthDTO refreshToken(String userName,String refreshToken) {

        return null;
    }

    @Override
    public User auth(@RequestParam("userName") String userName,@RequestParam("token") String token) throws APIException {
        String authKey = "AUTH_" + userName;
        User user = (User) redisTemplate.opsForHash().get(authKey,token);
        if (user != null) {
            return user;
        } else {
            throw new APIException(APIExceptionType.AUTH_FAILED);
        }
    }

    /**
     * 查询当前服务映射关系
     * 不加查询条件查询全部
     */
    @Override
    public List<GatewayApiRoute> getGatewayApiRoutes() {
        GatewayApiRouteExample example = new GatewayApiRouteExample();
        GatewayApiRouteExample.Criteria criteria = example.createCriteria();
        example.or(criteria);
        return gatewayApiRouteDao.selectByExample(example);
    }

    /**
     * 新增路由映射
     *
     * @param gatewayApiRoute
     */
    @Override
    public GatewayApiRoute addGatewayApiRoute(GatewayApiRoute gatewayApiRoute) {
        return null;
    }

    /**
     * 修改路由映射
     *
     * @param gatewayApiRoute
     */
    @Override
    public GatewayApiRoute updateGatewayApiRoute(GatewayApiRoute gatewayApiRoute) {
        return null;
    }
}
