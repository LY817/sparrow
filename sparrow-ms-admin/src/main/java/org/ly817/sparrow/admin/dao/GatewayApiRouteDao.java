package org.ly817.sparrow.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ly817.sparrow.api.pojo.GatewayApiRoute;
import org.ly817.sparrow.api.pojo.GatewayApiRouteExample;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GatewayApiRouteDao {
    long countByExample(GatewayApiRouteExample example);

    int deleteByExample(GatewayApiRouteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GatewayApiRoute record);

    int insertSelective(GatewayApiRoute record);

    List<GatewayApiRoute> selectByExample(GatewayApiRouteExample example);

    GatewayApiRoute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GatewayApiRoute record, @Param("example") GatewayApiRouteExample example);

    int updateByExample(@Param("record") GatewayApiRoute record, @Param("example") GatewayApiRouteExample example);

    int updateByPrimaryKeySelective(GatewayApiRoute record);

    int updateByPrimaryKey(GatewayApiRoute record);
}