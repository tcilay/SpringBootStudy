package com.hy.demo.demo.aspect;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hy.demo.demo.exception.AspectException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebValidAspect {

    @Pointcut("execution(* com.hy.demo.demo.service..*.*(..))")
    private void webPointCut(){}

    @Around("webPointCut()")
    public Object before(ProceedingJoinPoint jp) throws Exception,Throwable{
        System.out.println("my aop hahahhahah----------------");
        try{
            return  jp.proceed();
        }catch (AspectException e){
            System.out.println("my aspectexception hahahahha");
            throw e;
        }catch (Exception e){
            System.out.println("my exception hahahahha");
            throw e;
        }

    }


}
