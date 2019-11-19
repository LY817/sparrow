package org.ly817.sparrow.user;

import org.ly817.sparrow.api.feign.FUserService;

import org.ly817.sparrow.api.pojo.User;
import org.ly817.sparrow.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LY
 * @date 2019/11/03 22:16
 * <p>
 * Description:
 * 用户服务
 */
@RestController
public class UserServiceImpl implements FUserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public User addUser(User user) {
        return null;
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
