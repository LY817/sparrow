package org.ly817.sparrow.api.enums;

/**
 * @author LY
 * @date 2019/08/15 10:23
 * <p>
 * Description:
 * �쳣����
 * todo Ϊʲôʹ��utf-8����ᵼ��������� �����ļ���utf-8�����������
 */
public enum APIExceptionType {

    NPE("404","��ѯ���Ϊ��"), // ���ڿ�ֵ���
    AUTH_FAILED("408","��Ȩʧ��"),
    BAD_REQUEST("500","BAD_REQUEST"),
    BAD_REQUEST_PARAM("505","���������ֵ�쳣������API"),
    INTERNAL_SERVER_ERROR("501","INTERNAL_SERVER_ERROR"),
    // ��Ʒ
    PRODUCT_NOT_EXIST("10000","��Ʒ������"),
    INVENTORY_NOT_ENOUGH("10001","û���㹻�Ŀ��"),
    // ����
    ORDER_INVALID_PRICE("20001","�������۲��Ϸ�"),
    ORDER_NUMBER_OVER("20002","������Ʒ���������" ),
    ORDER_AMOUNT_INVALID("20003", "�����ܼ۲��Ϸ�"),
    // �Ż�ȯ
    COUPON_NOT_EXIST("30000","�Ż�ȯ������"),
    COUPON_NOT_USED("30001","�Ż�ȯ��ʹ��"),
    // �û�
    USER_NAME_DUPLICATE("40000","�û����ظ�"),
    USER_NAME_NOT_FOUND("40001","�û����������û�"),
    USER_NAME_PWD_INVALID("40002","�û������벻ƥ��"),
    USER_ADD_PARAM_INVALID("40003","�����û������쳣"),

    // ����
    PUSH_USER_NOT_ONLINE("90000","�û�������"),
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
