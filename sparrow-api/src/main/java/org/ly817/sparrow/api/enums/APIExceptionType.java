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
    AUTH_FAILED("408","鉴权失败"),
    BAD_REQUEST("500","BAD_REQUEST"),
    BAD_REQUEST_PARAM("505","请求参数传值异常，请检查API"),
    INTERNAL_SERVER_ERROR("501","INTERNAL_SERVER_ERROR"),
    // 商品
    PRODUCT_NOT_EXIST("10000","商品不存在"),
    INVENTORY_NOT_ENOUGH("10001","没有足够的库存"),
    // 订单
    ORDER_INVALID_PRICE("20001","订单单价不合法"),
    ORDER_NUMBER_OVER("20002","订单商品数量超库存" ),
    ORDER_AMOUNT_INVALID("20003", "订单总价不合法"),
    // 优惠券
    COUPON_NOT_EXIST("30000","优惠券不存在"),
    COUPON_NOT_USED("30001","优惠券已使用"),
    // 用户
    USER_NAME_DUPLICATE("40000","用户名重复"),
    USER_NAME_NOT_FOUND("40001","用户名不存在用户"),
    USER_NAME_PWD_INVALID("40002","用户名密码不匹配"),
    USER_ADD_PARAM_INVALID("40003","新增用户参数异常"),

    // 推送
    PUSH_USER_NOT_ONLINE("90000","用户不在线"),
    ;

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
