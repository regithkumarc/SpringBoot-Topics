package com.example.centralizedlog.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    private final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.example.centralizedlog.*.*.*(..) )")
    public void myPointCut() {}

    @Around("myPointCut()")
    public Object applicationLogInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] objects = proceedingJoinPoint.getArgs();
        logger.info("method invoked {} : {} () arguments : {}", className, methodName, objectMapper.writeValueAsString(objects));
        Object object = proceedingJoinPoint.proceed();
        logger.info("{} : {} () Response : {}", className, methodName, objectMapper.writeValueAsString(objects));
        return object;
    }
}
