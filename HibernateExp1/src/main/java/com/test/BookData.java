package com.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class BookData {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		Book obj = new Book();
		
		obj.setB_name("Hibernate notes");
		obj.setB_price(6500);
		obj.setB_author("Vidhan Bhasme");
 
		session.persist(obj);
		//t.commit();
		Book dt = session.get(Book.class, 252);
		System.out.println(dt.getId()+" "+dt.getB_name()+" "+ dt.getB_author()+" "+dt.getB_price());
		
		//dt.setB_name("Hibernate notes");
		//dt.setB_author("Vidhan Bhasme");
		//dt.setB_price(6500);
		
		//session.persist(dt);
		session.remove(dt);
		t.commit();
		System.out.println("Donee....");
		session.close();
		
		
	}
 
}
 
 