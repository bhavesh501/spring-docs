package com.bhavesh.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	// add a new advice for @AfterThrowing
	@AfterThrowing(
			pointcut="execution(* com.bhavesh.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n======>>> The Exception is: " + theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.bhavesh.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n======>>> result is: " + result);
		
		// lets post-process the data ... lets modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n======>>> result is: " + result);
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
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodsig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodsig);
		
		// display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
		
	}
	
}
