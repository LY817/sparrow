package org.ly817.sparrow.api.enums;

/**
 * Created by LuoYu on 2019/8/14.
 * 订单状态
 */
public enum OrderSts {

    PRE_CREATE("预创建",0),
    TO_PAY("代付款",1);

    OrderSts(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    String status;

    Integer code;
}
