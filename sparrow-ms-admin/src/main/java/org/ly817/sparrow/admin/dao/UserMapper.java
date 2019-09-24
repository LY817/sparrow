package org.ly817.sparrow.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.ly817.sparrow.api.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by LuoYu on 2019/9/23.
 */
@Repository
public interface UserMapper {
    /**
     * 有唯一索引的字段可以返回单个对象
     * 否则返回List，防止TooManyResultsException
     */
    User findUserByUsername(@Param("userName") String userName);

    User findUserByUserNameAndPwd(@Param("userName") String userName,@Param("pwd") String pwd);
}
