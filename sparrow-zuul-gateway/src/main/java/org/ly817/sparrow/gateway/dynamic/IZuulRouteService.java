package org.ly817.sparrow.gateway.dynamic;

import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.api.pojo.GatewayApiRouteExample;

import java.util.List;

/**
 * Created by LuoYu on 2020-01-05.
 */
public interface IZuulRouteService {
    public String key();

    public void save(GatewayApiRoute entity);

    public void delete(String id);

    public List<GatewayApiRoute> list(GatewayApiRouteExample condition);

    public List<GatewayApiRoute> listAll();

    public void clear();

    public void updateEnable(GatewayApiRoute entity);

    public int totalCount();

    public int enableCount();

    public void change(String namespace);

    public String count();
}
