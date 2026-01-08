package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class NamedQueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		//TypedQuery query = session.createNamedQuery("CustomQuery");
		//Transaction t = session.beginTransaction();
		//query.setParameter("name", "Hibernate Notes");
		
		
		Query query = session.createNamedQuery("customquery");
		query.setParameter("name", "Hibernate notes");
		List<Book> books = query.getResultList();

		//System.out.println("Named query result");
		System.out.println(books);
		session.close();
	}

}
