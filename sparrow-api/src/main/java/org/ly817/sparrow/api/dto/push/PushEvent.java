package org.ly817.sparrow.api.dto.push;

import java.io.Serializable;

/**
 * Created by LuoYu on 2019/11/16.
 */
public class PushEvent implements Serializable {
    /**
     * 推送类型
     */
    String pushType;

    /**
     * 业务分组
     */
    String pushGroup;


    String msg;

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getPushGroup() {
        return pushGroup;
    }

    public void setPushGroup(String pushGroup) {
        this.pushGroup = pushGroup;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
