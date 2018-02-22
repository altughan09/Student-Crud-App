package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							     .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student stu = new Student("Altughan","Ozengi","altughan.ozengi@gmail.com");
			
			session.beginTransaction();
			
			session.save(stu);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
		} finally {
			
			factory.close();
			
		}
		
	}
		
		
		
}
