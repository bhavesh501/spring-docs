package com.bhavesh.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// set pointcut declarations
	@Pointcut("execution(* com.bhavesh.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.bhavesh.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.bhavesh.springdemo.dao.*.*(..))")
	private void forDaoFlow() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoFlow()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display the method signature
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @Before: calling method: " + theMethod);
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the arguments and display them
		for (Object tempArg: args) {
			myLogger.info("=====>>>  argument: " + tempArg);
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display the method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturning: from method: " + theMethod);
		
		// display the data returned
		myLogger.info("======>>> result: " + theResult);
	}
}
