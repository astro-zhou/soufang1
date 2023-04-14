package com.soufang.soufang.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理器，将所有的异常封装成统一的 Api Response 响应体
 */
@RestControllerAdvice // spring mvc 提供的注解，用于标注异常控制器。 Rest -> @ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class) // @ExceptionHandler 用于捕获异常
    public ApiResponse<Object> handleBusinessException(BusinessException ex) {
        LOGGER.debug("business error: ", ex);
        return new ApiResponse<>(ex.getCode(), ex.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleInternalException(Exception ex) {
        LOGGER.error("internal error: ", ex);
        return new ApiResponse<>(Status.ERROR_INTERNAL);
    }
}
