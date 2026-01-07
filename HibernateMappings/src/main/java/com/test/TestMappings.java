package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMappings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		
		Address addr = new Address();
		Address addr2 = new Address();

		
		addr.setCity("Mumbai");
		addr.setState("Maharashtra");
		addr.setCountry("India");
		
		addr2.setCity("Bangalore");
		addr2.setState("Karnataka");
		addr2.setCountry("India");
		
		
		List<Address> addr1=Arrays.asList(addr, addr2);
		
		Employee1 emp = new Employee1();
		emp.setId(1);
		emp.setName("Ishita");
		emp.setCmp("Mphasis");
		emp.setAddress(addr); 
		
		Student stud = new Student();
		stud.setId(1);
		stud.setStd_name("Soham");
		stud.setAddresses(null);
		
		
		//session.persist(addr);
		//session.persist(emp);
		
		session.persist(addr);
		session.persist(addr2);
		session.persist(stud);

		
		t.commit();
		System.out.println("Doneeee");
		
		session.close();
 
	}

}
