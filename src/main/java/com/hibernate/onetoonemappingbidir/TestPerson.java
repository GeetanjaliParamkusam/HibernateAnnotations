package com.hibernate.onetoonemappingbidir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestPerson {

	public static void main(String[] args) {
			
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.addAnnotatedClass("hibernate.cfg.xml");
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		PersonDetail pD = new PersonDetail();
		pD.setZipCode("502319");
		pD.setJob("SoftwareDeveloper");
		pD.setIncome(58983.89);
		
		Person p = new Person();
		p.setPersonName("Ravi");
		
		p.setpDetail(pD);
		
		session.save(p);
		//session.save(pD);
		//no need if we set cascadeType.ALL
		session.getTransaction().commit();
		
	}

}
