package org.ly817.sparrow.admin.dao;

import org.ly817.sparrow.api.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by LuoYu on 2019/9/23.
 */
@Repository
public interface UserMapper {
    User findUserByUsername(String userName);
}
