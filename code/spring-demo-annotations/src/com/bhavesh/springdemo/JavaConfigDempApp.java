package com.bhavesh.springdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDempApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
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
