package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class HQLtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		//String hql ="From Book B";
		//String hql = "select b.b_name from Book b";
		String hql = "delete from Book b where b.id =:id";
		

		Query query = session.createQuery(hql);
		
		query.setParameter("id", 402);
		int row = query.executeUpdate();
		//List list = query.getResultList();
				System.out.println(row+" Deleted Successfully");
				session.close();
		
		
	}

}
