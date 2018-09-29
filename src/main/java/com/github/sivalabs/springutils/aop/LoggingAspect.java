package com.github.sivalabs.springutils.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This is a Spring AOP Aspect to log method entry/exit
 * along with execution time when debug log level enabled.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@within(com.github.sivalabs.springutils.aop.Loggable) || @annotation(com.github.sivalabs.springutils.aop.Loggable)")
    public Object logMethodEntryExit(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        String className = "";
        String methodName = "";
        if(log.isDebugEnabled()) {
            className = pjp.getSignature().getDeclaringTypeName();
            methodName = pjp.getSignature().getName();

            Object[] args = pjp.getArgs();
            String argumentsToString = "";
            if (args != null) {
                argumentsToString = Arrays.stream(args)
                        .map(arg -> (arg == null) ? null : arg.toString())
                        .collect(Collectors.joining(","));
            }
            log.debug(String.format("Entering method %s.%s(%s)", className, methodName, argumentsToString));
        }

        Object result = pjp.proceed();

        if(log.isDebugEnabled()) {
            long elapsedTime = System.currentTimeMillis() - start;
            log.debug(String.format("Exiting method %s.%s; Execution time (ms): %s", className, methodName, elapsedTime));
        }

        return result;
    }
}

