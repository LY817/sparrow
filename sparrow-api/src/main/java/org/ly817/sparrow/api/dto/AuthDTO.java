package org.ly817.sparrow.api.dto;

import java.io.Serializable;

/**
 * @author LY
 * @date 2019/09/24 12:42
 * <p>
 * Description:
 */
public class AuthDTO implements Serializable {
    /**
     * 是否登录验证成功
     */
    private Boolean authFlag;

    private String accessToken;

    private String refreshToken;

    private Integer expireIn = 3600;

    public Boolean getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(Boolean authFlag) {
        this.authFlag = authFlag;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }
}
