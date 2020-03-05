package com.bhavesh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhavesh.aopdemo.dao.AccountDAO;
import com.bhavesh.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		// display the accounts
		System.out.println("\n\nMain Progarm: AfterReturningDempApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		// close the context
		context.close();

	}

}
