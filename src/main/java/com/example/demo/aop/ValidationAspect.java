package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.demo.service.ProductService.getProductById(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        if (postId < 0) {
            LOGGER.info("Id can not be negative, changing Id : " + postId);
            postId = -postId;
        }
        LOGGER.info("Id is : " + postId);
        Object obj = jp.proceed();
        return obj;

    }
}
