package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavesh.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Student object....");
			Student tempStudent = new Student("Paul", "Wall", "paul@bhavesh.com");
			
			// create a student object
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
	}

}
