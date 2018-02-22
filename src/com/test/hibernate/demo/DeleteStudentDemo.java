package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("delete from Student where firstName='Ahmetcan'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("deletion done");

		} finally {

			factory.close();

		}

	}

}
