package com.bhavesh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDempApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve the bean from container
		// Coach.class is the interface
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();

	}

}
