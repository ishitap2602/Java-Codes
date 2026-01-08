package com.test;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
 
public class CustomerDAO {
	
	public static Customer getCustomerById(int input) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
 
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
 
		Transaction t = session.beginTransaction();
		String hql = "from Customer where id = :id";
		
		Query query = session.createQuery(hql, Customer.class);
		query.setParameter("id", input);
		
		System.out.println("CUSTOMER ID: "+ input);
		
		List<Customer> list = query.getResultList();
		t.commit();
		
		Customer dt = new Customer(input);
		for(Customer c:list) {
			System.out.println(c);
			dt=c;
		}
		return dt;
		
	}
	
	public static void addCustomer(Customer cst) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
 
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
 
		Transaction t = session.beginTransaction();
		
		session.persist(cst);
		
		t.commit();
		
		session.close();
		
	}
 
}
 
 