package com.xworkz.cinexa.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmailAspect {

    @Before("execution(* com.xworkz.cinexa.service.implementation.EmailService.*(..))")
    public void logBeforeEmail(JoinPoint joinPoint) {
        log.info("Email method invoked: {}", joinPoint.getSignature().getName());
        log.info("Start Time: {}", System.currentTimeMillis());
    }


    @AfterReturning(
            pointcut = "execution(* com.xworkz.cinexa.service.implementation.EmailService.*(..))",
            returning = "result"
    )
    public void afterEmailSuccess(JoinPoint joinPoint, Object result) {

        log.info("Email sent successfully");
        log.info("Method: {}", joinPoint.getSignature().getName());
        log.info("Return Value: {}", result);
    }
}
