package com.bhavesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bhavesh.hibernate.demo.entity.Course;
import com.bhavesh.hibernate.demo.entity.Instructor;
import com.bhavesh.hibernate.demo.entity.InstructorDetail;
import com.bhavesh.hibernate.demo.entity.Review;
import com.bhavesh.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

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
			
			// get the student from database
			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);
			
			// display the courses for the student
			System.out.println("Student: " + tempStudent);
			System.out.println("Student courses: " + tempStudent.getCourses());
			
			// get the pacman course from db
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			session.delete(tempCourse);
			
			// get the student from database
			tempStudent = session.get(Student.class, studentId);
			
			// display the courses for the student
			System.out.println("Student: " + tempStudent);
			System.out.println("Student courses: " + tempStudent.getCourses());
			
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
