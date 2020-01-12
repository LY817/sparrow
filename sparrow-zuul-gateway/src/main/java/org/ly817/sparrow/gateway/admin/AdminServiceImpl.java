package org.ly817.sparrow.gateway.admin;

import io.jsonwebtoken.Claims;
import org.ly817.sparrow.api.dto.AuthDTO;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.api.pojo.GatewayApiRouteExample;
import org.ly817.sparrow.api.pojo.User;
import org.ly817.sparrow.api.service.IAdminService;
import org.ly817.sparrow.api.service.IUserService;
import org.ly817.sparrow.common.SnowflakeIdWorker;
import org.ly817.sparrow.gateway.dao.GatewayApiRouteDao;
import org.ly817.sparrow.global.auth.JwtOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * @author LY
 * @date 2019/09/24 10:13
 * <p>
 * Description:
 */
@RestController
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private JwtOperator jwtOperator;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private IUserService fUserService;

    @Autowired
    private GatewayApiRouteDao gatewayApiRouteDao;


    /**
     * 系统用户名密码登录
     */
    @Override
    public AuthDTO login(@RequestParam("userName") String userName,
                         @RequestParam("password") String password) {
        User existUser = fUserService.findUserByUserNameAndPwd(userName,password);
        AuthDTO authDTO = new AuthDTO();
        if (existUser != null) {
            authDTO.setAuthFlag(true);
            HashMap<String,Object> payload = new HashMap<>();
            payload.put("userId",existUser.getUserId());
            payload.put("userType",existUser.getUserType());
            authDTO.setJwt(jwtOperator.generateToken(payload));
        } else {
            authDTO.setAuthFlag(false);
            throw new APIException(APIExceptionType.AUTH_FAILED);
        }
        return authDTO;
    }

    /**
     * 通过小程序code登录
     */
    @Override
    public AuthDTO login(String code) {
        return null;
    }

    @Override
    public AuthDTO refreshToken(String userName,String refreshToken) {

        return null;
    }

    @Override
    public User auth(@RequestParam("token") String token) throws APIException {
//        String authKey = "AUTH_" + userName;
//        User user = (User) redisTemplate.opsForHash().get(authKey,token);
        if (jwtOperator.validateToken(token)) {
            Claims claims = jwtOperator.getClaimsFromToken(token);
            Long userId = claims.get("userId",Long.class);
            return fUserService.findUserById(userId);
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
        gatewayApiRoute.setId(idWorker.nextId());
        gatewayApiRouteDao.insert(gatewayApiRoute);
        return gatewayApiRoute;
    }

    /**
     * 修改路由映射
     *
     * @param gatewayApiRoute
     */
    @Override
    public GatewayApiRoute updateGatewayApiRoute(GatewayApiRoute gatewayApiRoute) {
        gatewayApiRouteDao.updateByPrimaryKey(gatewayApiRoute);
        return gatewayApiRoute;
    }
}
