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
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.bhavesh.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create poincut for setter methods
	@Pointcut("execution(* com.bhavesh.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}
}
