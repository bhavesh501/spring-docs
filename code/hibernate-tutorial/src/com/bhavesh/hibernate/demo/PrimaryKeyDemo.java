package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavesh.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Student object....");
			Student tempStudent1 = new Student("John", "Doe", "john@bhavesh.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@bhavesh.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@bhavesh.com");
			
			// create 3 student objects
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}

	}

}
