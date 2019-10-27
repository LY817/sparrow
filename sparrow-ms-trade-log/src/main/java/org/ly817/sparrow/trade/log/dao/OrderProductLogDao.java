package org.ly817.sparrow.trade.log.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ly817.sparrow.api.pojo.OrderProductLog;
import org.ly817.sparrow.api.pojo.OrderProductLogExample;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductLogDao {
    long countByExample(OrderProductLogExample example);

    int deleteByExample(OrderProductLogExample example);

    int insert(OrderProductLog record);

    int insertSelective(OrderProductLog record);

    List<OrderProductLog> selectByExample(OrderProductLogExample example);

    int updateByExampleSelective(@Param("record") OrderProductLog record, @Param("example") OrderProductLogExample example);

    int updateByExample(@Param("record") OrderProductLog record, @Param("example") OrderProductLogExample example);
}