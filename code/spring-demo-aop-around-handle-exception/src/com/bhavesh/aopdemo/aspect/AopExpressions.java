package com.bhavesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

	@Pointcut("execution(* com.bhavesh.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.bhavesh.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create poincut for setter methods
	@Pointcut("execution(* com.bhavesh.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
