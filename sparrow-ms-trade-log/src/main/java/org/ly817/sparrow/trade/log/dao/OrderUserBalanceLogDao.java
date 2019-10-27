package org.ly817.sparrow.trade.log.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ly817.sparrow.api.pojo.OrderUserBalanceLog;
import org.ly817.sparrow.api.pojo.OrderUserBalanceLogExample;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderUserBalanceLogDao {
    long countByExample(OrderUserBalanceLogExample example);

    int deleteByExample(OrderUserBalanceLogExample example);

    int insert(OrderUserBalanceLog record);

    int insertSelective(OrderUserBalanceLog record);

    List<OrderUserBalanceLog> selectByExample(OrderUserBalanceLogExample example);

    int updateByExampleSelective(@Param("record") OrderUserBalanceLog record, @Param("example") OrderUserBalanceLogExample example);

    int updateByExample(@Param("record") OrderUserBalanceLog record, @Param("example") OrderUserBalanceLogExample example);
}