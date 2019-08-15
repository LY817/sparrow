package org.ly817.sparrow.api.exception;

import org.ly817.sparrow.api.enums.APIExceptionType;

/**
 * @author LY
 * @date 2019/08/15 10:13
 * <p>
 * Description:
 * 异常统一处理
 * 将逻辑异常封装成API状态码中的
 */
public class APIException extends Throwable {

    private String code;

    private APIExceptionType type;

    public APIException(String message, String code) {
        super(message);
        this.code = code;
    }

    public APIException(APIExceptionType type){
        super(type.getMsg());
        this.code = type.getCode();
    }

    public APIException(APIExceptionType type , String extMsg){
        super(type.getMsg() + ":" + extMsg);
        this.type = type;
        this.code = type.getCode();
    }

    public String getCode() {
        return code;
    }

    public APIExceptionType getType() {
        return type;
    }
}
