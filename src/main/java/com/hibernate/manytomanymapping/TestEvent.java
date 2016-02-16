package com.hibernate.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestEvent {

	public static void main(String[] args) {
			
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Delegate.class);
		config.addAnnotatedClass(Event.class);
		
		config.addAnnotatedClass("hibernate.cfg.xml");
		
		//new SchemaExport(config).create(true,true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Delegate d1 = new Delegate();
		d1.setDelegateName("Navya");
		Delegate d2 = new Delegate();
		d2.setDelegateName("Sandy");
		Delegate d3 = new Delegate();
		d3.setDelegateName("Divya");
		Delegate d4 = new Delegate();
		d4.setDelegateName("Geeta");
		
		Event java1O1 = new Event();
		java1O1.setEventName("Java - 1O1");
		Event cplus1O1 = new Event();
		cplus1O1.setEventName("C++ - 1O1");
		Event math1O1 = new Event();
		math1O1.setEventName("Math - 1O1");
		
		java1O1.getDelegates().add(d1);
		java1O1.getDelegates().add(d2);
		java1O1.getDelegates().add(d3);
		cplus1O1.getDelegates().add(d2);
		cplus1O1.getDelegates().add(d3);
		math1O1.getDelegates().add(d4);
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);
		session.save(java1O1);
		session.save(cplus1O1);
		session.save(math1O1);
		session.getTransaction().commit();
		
	}
}