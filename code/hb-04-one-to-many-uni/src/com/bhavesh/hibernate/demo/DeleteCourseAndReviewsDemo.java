package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bhavesh.hibernate.demo.entity.Course;
import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction();
			
			// get the course
			// in the sql for create course query, we did auto-increment for 10. So first id will start from 10
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// print the course
			System.out.println("Deleting the course ...");
			System.out.println("tempCourse: " + tempCourse);
			
			// print the course reviews
			System.out.println("tempCourse reviews: " + tempCourse.getReviews());
			
			// delete the course
			session.delete(tempCourse);
			
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
