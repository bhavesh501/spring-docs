package com.bhavesh.springdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDempApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		/* since the SwimCoach has additional getter methods that are not present in Coach interface we are creating object with
		SwimCoach on left side and SwimCoach.class on right side */
		
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call the method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the getFortuneService method
		System.out.println(theCoach.getDailyFortune());
		
		// call swim coach methods that returns values from properties file
		System.out.println("Email: " + theCoach.getEmail());
		
		System.out.println("Team: " + theCoach.getTeam());
		 
		// close the context
		context.close();

	}

}
