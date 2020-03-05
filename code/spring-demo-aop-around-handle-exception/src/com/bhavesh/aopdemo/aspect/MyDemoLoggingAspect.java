package com.bhavesh.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bhavesh.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// add a new @Around advice
	@Around("execution(* com.bhavesh.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		Object result = null;
		
		try {
			// execute the method
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// Handling Exception by giving user a custom message
			/*
			result = "Major accident! But no worries, " + 
			"your private AOP helicopter is on the way!";
			*/
			// rethrowing the exception
			throw e;
		}
		
		
		// get the end timestamp
		long end = System.currentTimeMillis();
		
		// display the complete duration 
		long duration = end - begin;
		myLogger.info("\n=====>>> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	// add a new adivice @After
	@After("execution(* com.bhavesh.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
	}
	
	// add a new advice for @AfterThrowing
	@AfterThrowing(
			pointcut="execution(* com.bhavesh.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n======>>> The Exception is: " + theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.bhavesh.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n======>>> result is: " + result);
		
		// lets post-process the data ... lets modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n======>>> result is: " + result);
	}
	
	public void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for (Account tempAccount : result) {
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
	}
	
	@Before("com.bhavesh.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=====>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodsig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodsig);
		
		// display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
		
	}
	
}
