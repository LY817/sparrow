package org.ly817.sparrow.api.enums;

/**
 * @author LY
 * @date 2019/08/15 10:23
 * <p>
 * Description:
 * 异常类型
 * todo 为什么使用utf-8编码会导致输出乱码 其他文件用utf-8输出中文正常
 */
public enum APIExceptionType {

    NPE("404","查询结果为空"), // 用于空值检查
    BAD_REQUEST("500","BAD_REQUEST"),
    BAD_REQUEST_PARAM("505","请求参数传值异常，请检查API"),
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
