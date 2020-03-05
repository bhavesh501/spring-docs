package com.bhavesh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhavesh.aopdemo.dao.AccountDAO;
import com.bhavesh.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get the membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the accountdao getter and setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();

	}

}
