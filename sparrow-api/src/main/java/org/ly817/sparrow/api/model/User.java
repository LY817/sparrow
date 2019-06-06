package org.ly817.sparrow.api.model;

/**
 * @author LuoYu
 * @date 2019/06/06 8:49
 * <p>
 * Description:
 * 用户实体类
 */
public class User {
    private Long userId;

    private String userName;

    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
