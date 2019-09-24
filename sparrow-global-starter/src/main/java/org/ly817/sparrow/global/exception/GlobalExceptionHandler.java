package org.ly817.sparrow.global.exception;

import org.ly817.sparrow.api.dto.APIResponse;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LY
 * @date 2019/08/15 13:30
 * <p>
 * Description:
 * controller处理异常
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler({org.springframework.web.bind.MissingServletRequestParameterException.class})
    @ResponseBody
    public APIResponse processRequestParameterException(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        MissingServletRequestParameterException e) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        APIResponse result = new APIResponse();
        result.setCode(APIExceptionType.BAD_REQUEST_PARAM.getCode());
        result.setMsg(APIExceptionType.BAD_REQUEST_PARAM.getMsg());
        return result;
    }

    @ExceptionHandler(APIException.class)
    @ResponseBody
    public APIResponse processApiException(HttpServletResponse response,
                                           APIException e) {
        APIResponse result = new APIResponse();
        // HttpStatus 5xx没有涉及512 表示业务逻辑错误
        response.setStatus(512);
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
//        result.setCode(e.getType().getCode());
        result.setCode(e.getCode());
        String message = e.getMessage();
        result.setMsg(message);
        logger.error("Known exception", e.getMessage(), e);
        return result;
    }
}
