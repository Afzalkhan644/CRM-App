package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProdLoggingAspect {
private Logger logger=Logger.getLogger(getClass().getName());
@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
private void forControllerPackage() {
	
	
}
@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
private void forServicePackage() {
	
	
}
@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
private void forDaoPackage() {
	
	
}
@Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
private void forAppFlow() {}

@Before("forAppFlow()")
public void before(JoinPoint theJoinPoint) {
	String theMethod=theJoinPoint.getSignature().toShortString();
	logger.info("==> in before:calling method:"+theMethod);

Object[] args =theJoinPoint.getArgs();

for(Object tempArg : args) {
	
	logger.info("===>> argument:"+tempArg);
}
}
@AfterReturning(
		pointcut="forAppFlow()",
		returning="theResult"
		)
public void afterReturning(JoinPoint theJointPoint, Object theResult)
{

	String theMethod= theJointPoint.getSignature().toShortString();
	logger.info("==> in @AfterReturning:calling method:"+theMethod);

	logger.info("===>> argument:"+theResult);
	
}
}
