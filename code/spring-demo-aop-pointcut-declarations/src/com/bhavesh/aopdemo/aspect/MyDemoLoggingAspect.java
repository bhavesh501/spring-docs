package com.bhavesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all our related advices for logging
	
	// lets start with @Before advice
	
	@Pointcut("execution(* com.bhavesh.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}
}
