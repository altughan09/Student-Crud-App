package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student stu1 = new Student("Altughan", "Ozengi", "altughan.ozengi@gmail.com");
			Student stu2 = new Student("Olga", "Ozengi", "olga.ozengi@gmail.com");
			Student stu3 = new Student("Ahmetcan", "Mehmetcan", "ahmetcan@gmail.com");

			session.beginTransaction();

			session.save(stu1);
			session.save(stu2);
			session.save(stu3);

			session.getTransaction().commit();

			System.out.println("done");

		} finally {

			factory.close();

		}

	}

}
