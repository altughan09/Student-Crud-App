package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							     .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int id = 1; // update selected row
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, id);
			
			System.out.println("Completed: "+ myStudent);
			
			System.out.println("updating students...");
			
			myStudent.setFirstName("Altughhh");
			
			session.getTransaction().commit();
			
			System.out.println("done" + myStudent);
			
			
			
			session = factory.getCurrentSession(); //new transaction - update all emails
			session.beginTransaction();
			
			session.createQuery("update Student set email='altug@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();

			
			System.out.println("update done");
			
			
			
			
		} finally {
			
			factory.close();
			
		}
		
	}
		
		
		
}
