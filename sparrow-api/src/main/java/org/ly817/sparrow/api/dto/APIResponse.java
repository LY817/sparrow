package org.ly817.sparrow.api.dto;

import java.io.Serializable;

/**
 * @author LY
 * @date 2019/08/15 10:13
 * <p>
 * Description:
 */
public class APIResponse implements Serializable {

    private String code = "200";

    private String msg;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
