package org.ly817.sparrow.user;

import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.feign.FUserService;

import org.ly817.sparrow.api.pojo.User;
import org.ly817.sparrow.api.pojo.UserExample;
import org.ly817.sparrow.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public User findUserByName(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        example.or(criteria);
        List<User> users = userDao.selectByExample(example);
        if (users.size() == 1) {
            return users.get(0);
        } else if (users.size() > 0) {
            throw new APIException(APIExceptionType.USER_NAME_DUPLICATE);
        } else {
            throw new APIException(APIExceptionType.USER_NAME_NOT_FOUND);
        }
    }

    /**
     * 根据用户名和密码查找记录
     *
     * @param userName 用户名
     * @param pwd      密码
     * @return
     */
    @Override
    public User findUserByUserNameAndPwd(String userName, String pwd) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(pwd);
        example.or(criteria);
        List<User> users = userDao.selectByExample(example);
        if (users.size() == 1) {
            return users.get(0);
        } else if (users.size() > 0) {
            throw new APIException(APIExceptionType.USER_NAME_DUPLICATE);
        } else {
            throw new APIException(APIExceptionType.USER_NAME_PWD_INVALID);
        }
    }
}
