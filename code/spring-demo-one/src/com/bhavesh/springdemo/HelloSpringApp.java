package com.bhavesh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from container
		// Coach.class is the interface
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method getDailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
