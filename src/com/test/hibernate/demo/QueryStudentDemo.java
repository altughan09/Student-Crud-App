package com.test.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							     .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
						
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();
			
			for(Student tempStudent: students) {
				System.out.println(tempStudent);
			}
			
			students = session.createQuery("from Student s where s.lastName='Ozengi'").getResultList();
			System.out.println(students);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
		} finally {
			
			factory.close();
			
		}
		
	}
		
		
		
}
