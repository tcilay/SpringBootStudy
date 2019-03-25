package com.hy.demo.demo.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理全局异常
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle  {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandle(HttpServletRequest request,Exception e){
        return e.getMessage();
    }

}
