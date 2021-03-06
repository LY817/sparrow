package org.ly817.sparrow.gateway.dynamic;

import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.api.pojo.GatewayApiRouteExample;
import org.ly817.sparrow.gateway.dao.GatewayApiRouteDao;

import java.util.List;

/**
 * @author LY
 * @date 2020/01/05 21:43
 * <p>
 * Description:
 * zuul动态网关路由数据数据库实现
 */
public class ZuulRouteServiceDBImpl implements IZuulRouteService {

    private final GatewayApiRouteDao gatewayApiRouteDao;

    public ZuulRouteServiceDBImpl(GatewayApiRouteDao gatewayApiRouteDao) {
        this.gatewayApiRouteDao = gatewayApiRouteDao;
    }

    @Override
    public String key() {
        return null;
    }

    @Override
    public void save(GatewayApiRoute entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<GatewayApiRoute> list(GatewayApiRouteExample example) {
        return null;
    }

    @Override
    public List<GatewayApiRoute> listAll() {
        GatewayApiRouteExample example = new GatewayApiRouteExample();
        GatewayApiRouteExample.Criteria criteria = example.createCriteria();
        example.or(criteria);
        return gatewayApiRouteDao.selectByExample(example);
    }

    @Override
    public void clear() {

    }

    @Override
    public void updateEnable(GatewayApiRoute entity) {

    }

    @Override
    public int totalCount() {
        return 0;
    }

    @Override
    public int enableCount() {
        return 0;
    }

    @Override
    public void change(String namespace) {

    }

    @Override
    public String count() {
        return null;
    }
}
