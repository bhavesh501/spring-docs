package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bhavesh.hibernate.demo.entity.Course;
import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
			
			// start the transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			
			// option1: call getter methods while session is open
			// Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// option2: Hibernate query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+ "JOIN FETCH i.courses "
														+ "where i.id=:theInstructorId",
														Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// since the courses are lazy loaded...this should fail
			// get the course for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!!!");
		}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
