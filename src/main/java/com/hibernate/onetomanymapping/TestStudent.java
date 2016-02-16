package com.hibernate.onetomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestStudent {

	public static void main(String[] args) {
			
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(College.class);
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass("hibernate.cfg.xml");
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		College c = new College();
		c.setCollegeName("TRR College");
		
		Student s1 = new Student();
		s1.setStudentName("Navya");
		
		Student s2 = new Student();
		s2.setStudentName("Divya");
		
		s1.setCollege(c);
		s2.setCollege(c);
		
		session.save(c);
		session.save(s1);
		session.save(s2);

		session.getTransaction().commit();
		
	}

}
