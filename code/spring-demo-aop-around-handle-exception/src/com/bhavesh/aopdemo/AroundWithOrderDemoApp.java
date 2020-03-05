package com.bhavesh.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhavesh.aopdemo.dao.AccountDAO;
import com.bhavesh.aopdemo.dao.MembershipDAO;
import com.bhavesh.aopdemo.service.TrafficFortuneService;

public class AroundWithOrderDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundWithOrderDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read the spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDempApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theTrafficFortuneService.getFortune();
		
		myLogger.info("\nMy Fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();

	}

}
