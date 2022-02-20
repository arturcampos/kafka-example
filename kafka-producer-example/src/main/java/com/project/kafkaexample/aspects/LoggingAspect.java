package com.project.kafkaexample.aspects;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Around("@annotation(loggable)")
  public Object logMethodCall(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
    return handleJoinPoint(joinPoint);
  }

  @Around(
      "execution(* com.project.kafkaexample..*Resource*.*(..)) || execution(*  com.project.kafkaexample..*Repository*.*(..))")
  public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
    return handleJoinPoint(joinPoint);
  }

  private Object handleJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
    final Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
    final String methodName = joinPoint.getSignature().getName();
    final Object[] args = joinPoint.getArgs();
    final String argsStr =
        Arrays.stream(args).map(String::valueOf).collect(Collectors.joining(",", "[", "]"));

    log.info("[m=" + methodName + "] - Begin of " + methodName + " with arguments " + argsStr);

    final Object result = joinPoint.proceed();

    log.info("[m=" + methodName + "] - End of " + methodName + " resulting in " + result);

    return result;
  }
}
