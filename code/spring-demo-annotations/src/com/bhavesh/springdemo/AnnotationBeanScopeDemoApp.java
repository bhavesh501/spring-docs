package com.bhavesh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve beans from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// print the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location of theCoach: " + theCoach);
		
		System.out.println("\nMemory location of alphaCoach: " + alphaCoach);
		
		// close the context
		context.close();
	}

}
