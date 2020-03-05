package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavesh.hibernate.demo.entity.Course;
import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "Susan.public@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Video Games");
			
			/*
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com", "Guitar");
			*/
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start the transaction
			session.beginTransaction();
			
			// save the transaction.
			// tempInstructor will also save tempInstructorDetail as we have enabled Cascading for ALL the operations (CascadeType.ALL)
			System.out.println("Saving instructor: " + tempInstructor.toString());
			session.save(tempInstructor);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
