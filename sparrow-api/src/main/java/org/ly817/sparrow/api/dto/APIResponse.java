package org.ly817.sparrow.api.dto;

import lombok.*;
import org.ly817.sparrow.api.enums.APIExceptionType;

import java.io.Serializable;

/**
 * @author LY
 * @date 2019/08/15 10:13
 * <p>
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse implements Serializable {

    private String code;

    private String msg;

    private Object payload;

    public boolean isSuccess(){
        return "200".equals(code);
    }

    public APIResponse(APIExceptionType exceptionType) {
        this.setCode(exceptionType.getCode());
        this.setMsg(exceptionType.getMsg());
    }

    public static APIResponse success(Object data){
        return APIResponse.builder().code("200").payload(data).build();
    }
}
