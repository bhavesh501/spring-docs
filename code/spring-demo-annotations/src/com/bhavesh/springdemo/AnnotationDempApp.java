package com.bhavesh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDempApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call the method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the getFortuneService method
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
