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
    BAD_REQUEST("500","BAD_REQUEST"),
    BAD_REQUEST_PARAM("505","���������ֵ�쳣������API"),
    INTERNAL_SERVER_ERROR("501","INTERNAL_SERVER_ERROR"),
    INVENTORY_NOT_ENOUGH("10001","û��ס���Ŀ��");

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
