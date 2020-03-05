package com.bhavesh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve the bean from container
		// Coach.class is the interface
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are same beans
		boolean result = (theCoach == alphaCoach);
		
		//printing the results
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location of theCoach: "+ theCoach);
		
		System.out.println("\nMemory location of theCoach: "+ alphaCoach);
		
		context.close();

	}

}
