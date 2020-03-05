package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavesh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Student object....");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@bhavesh.com");
			
			// create a student object
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			// Commit the transaction
			session.getTransaction().commit();
			
			// My new code
			// find out the students's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
	}

}
