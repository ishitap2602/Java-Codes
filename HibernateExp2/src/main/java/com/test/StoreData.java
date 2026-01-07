package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Player p1 = new Player();
		p1.setName("Ishita Patel");
		
		Cricketer c1 = new Cricketer();
		c1.setName("Ishita Patel");
		c1.setType("All rounder");
		c1.setJerseyNumber("1");
		
		TennisPlayer t1 = new TennisPlayer();
		t1.setName("Jay Manek");
		t1.setNoOfMathes(5);
		t1.setWonMatches(1);
		
		session.persist(p1);
		session.persist(c1);
		session.persist(t1);

		
		t.commit();
		System.out.println("Done !");
		session.close();
		
	}

}
