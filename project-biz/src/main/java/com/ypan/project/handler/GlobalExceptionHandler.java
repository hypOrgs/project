package com.ypan.project.handler;

import com.ypan.base.BaseResult;
import com.ypan.project.exception.BusinessException;
import com.ypan.project.exception.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public BaseResult handleBusException(BusinessException e) {
        log.error("捕获到异常:[{}]", e.getMessage(), e);
        return BaseResult.failed(e.getMessage());
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public BaseResult handleUnAException(UnAuthorizedException e, HttpServletResponse response) {
        log.error("捕获到异常:[{}]", e.getMessage(), e);
        response.setStatus(401);
        return BaseResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public BaseResult handleException(Exception e) {
        log.error("捕获到异常:[{}]", e.getMessage(), e);
        return BaseResult.failed(e.getMessage());
    }
}
