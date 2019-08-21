package org.ly817.sparrow.api.model;

import java.io.Serializable;

/**
 * @author LuoYu
 * @date 2019/06/06 8:49
 * <p>
 * Description:
 * 用户实体类
 */
public class User implements Serializable {
    private String userId;

    private String userName;

    private String password;

    private Long creditScore;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public Long getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Long creditScore) {
        this.creditScore = creditScore;
    }
}
