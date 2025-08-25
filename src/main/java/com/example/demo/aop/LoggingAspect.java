package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)

    @Before("execution(* com.example.demo.service.ProductService.*(..))")
    public void logBeforeMethodCall(JoinPoint jp){
        LOGGER.info("Before Method Called : " + jp.getSignature().getName());
    }

//    @After("execution(* com.example.demo.service.ProductService.getAllProducts(..)) || execution(* com.example.demo.service.ProductService.updateProduct(..))")
//    public void logAfterMethodCall(JoinPoint jp){
//        LOGGER.info("After Method Called : " + jp.getSignature().getName());
//    }

    @After("execution(* com.example.demo.service.ProductService.*(..))")
    public void logAfterMethodCall(JoinPoint jp){
        LOGGER.info("After Method Called : " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.demo.service.ProductService.*(..))")
    public void logAfterThrowingError(JoinPoint jp){
        LOGGER.info("After throwing exception : " + jp.getSignature().getName());
    }
}
