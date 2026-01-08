package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;

public class CriteriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		//crate SessionFactory object
		SessionFactory sf = cfg.buildSessionFactory();
		
		//create Session object
		Session session = sf.openSession();
		
		//create transaction object
		Transaction t = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		cq.distinct(true);
		Root<Book>rt = cq.from(Book.class);
		cq.select(rt);
		TypedQuery<Book> tq = session.createQuery(cq);
		List<Book> books = tq.getResultList();
		System.out.println(books);
		
		
	}

}
