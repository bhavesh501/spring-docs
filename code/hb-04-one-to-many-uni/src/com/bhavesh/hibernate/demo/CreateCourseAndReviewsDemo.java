package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bhavesh.hibernate.demo.entity.Course;
import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How to Score One Million Points");
			
			// add some reviews
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course ... job well done!"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println("tempCourse: " + tempCourse);
			System.out.println("tempCourse reviews: " + tempCourse.getReviews());
			session.save(tempCourse);
			
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
