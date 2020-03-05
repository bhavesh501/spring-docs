package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bhavesh.hibernate.demo.entity.Course;
import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Review;
import com.bhavesh.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman - How to Score One Million Points");
			
			// save the course and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println("tempCourse: " + tempCourse);
			
			// save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			
			// add the students
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("\nSaving the students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
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
