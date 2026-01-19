package com.xworkz.cinexa.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AdminAspect {


    @Around("execution(* com.xworkz.cinexa.service.implementation.AdminServiceImpl.*(..))")
    public Object adminAop(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();


        log.info("Method Started: {}", joinPoint.getSignature().getName());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        log.info("Method Completed: {}", joinPoint.getSignature().getName());
        log.info("Execution Time: {} ms", (endTime - startTime));

        return result;
    }


    @AfterReturning(pointcut = "execution(* com.xworkz.cinexa.service.implementation.AdminServiceImpl.*(..))",returning = "return")
    public void adminReturnAop(JoinPoint point,Object result){
        log.info("Successfully Excepted method {}",point.getSignature().getName());
        log.info("Returning Value {}",result);
    }

    @AfterThrowing(pointcut = "execution(* com.xworkz.cinexa.service.implementation.AdminServiceImpl.*(..))",throwing = "ex")
    public void adminExceptionAop(JoinPoint joinPoint,Exception ex){
        log.error("Exception in Method {}",joinPoint.getSignature().getName());
        log.error("Exception Message {}",ex.getMessage());
    }
}
