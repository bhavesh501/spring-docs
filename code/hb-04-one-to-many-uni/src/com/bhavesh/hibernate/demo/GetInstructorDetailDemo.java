package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 2999;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// print the associated instructor
			System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
