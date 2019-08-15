package org.ly817.sparrow.global.handler;

import org.ly817.sparrow.api.dto.APIResponse;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LY
 * @date 2019/08/15 13:30
 * <p>
 * Description:
 * 全局处理异常
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
        APIResponse result = new APIResponse();
        result.setCode(APIExceptionType.BAD_REQUEST.getCode());
        result.setMsg(APIExceptionType.BAD_REQUEST.getMsg());
        return result;
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
    public APIResponse processDefaultException(HttpServletResponse response,
                                               Exception e) {
        logger.error("Server exception", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        APIResponse result = new APIResponse();
        result.setCode(APIExceptionType.INTERNAL_SERVER_ERROR.getCode());
        result.setMsg(APIExceptionType.INTERNAL_SERVER_ERROR.getMsg());
        return result;
    }

    @ExceptionHandler(APIException.class)
    @ResponseBody
    public APIResponse processApiException(HttpServletResponse response,
                                           APIException e) {
        APIResponse result = new APIResponse();
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setContentType("application/json;charset=UTF-8");
        result.setCode(e.getType().getCode());
        String message = e.getMessage();
        result.setMsg(message);
        logger.error("Known exception", e.getMessage(), e);
        return result;
    }

    /**
     * 内部微服务异常统一处理方法
     */
//    @ExceptionHandler(InternalApiException.class)
//    @ResponseBody
//    public APIResponse processMicroServiceException(HttpServletResponse response,
//                                                    InternalApiException e) {
//        response.setStatus(HttpStatus.OK.value());
//        response.setContentType("application/json;charset=UTF-8");
//        APIResponse result = new APIResponse();
//        result.setCode(e.getCode());
//        result.setMsg(e.getMessage());
//        return result;
//    }
}
