package com.bhavesh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhavesh.aopdemo.dao.AccountDAO;
import com.bhavesh.aopdemo.dao.MembershipDAO;
import com.bhavesh.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDempApp");
		
		System.out.println("Calling getFortune");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy Fortune is: " + data);
		
		System.out.println("Finished");
		
		// close the context
		context.close();

	}

}
