package org.ly817.sparrow.api.enums;

/**
 * @author LY
 * @date 2019/08/15 10:23
 * <p>
 * Description:
 * 异常类型
 */
public enum APIExceptionType {

    NPE("404","查询结果为空"), // 用于空值检查
    BAD_REQUEST("500","BAD_REQUEST"),
    INTERNAL_SERVER_ERROR("501","INTERNAL_SERVER_ERROR"),
    INVENTORY_NOT_ENOUGH("10001","没有住够的库存");

    private String  code;

    private String msg;

    APIExceptionType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}