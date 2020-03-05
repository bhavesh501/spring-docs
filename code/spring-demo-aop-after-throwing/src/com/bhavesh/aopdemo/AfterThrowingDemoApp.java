package com.bhavesh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhavesh.aopdemo.dao.AccountDAO;
import com.bhavesh.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate the exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\nMain Program .. caught exception: " + exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain Progarm: AfterThrowingDempApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		// close the context
		context.close();

	}

}
