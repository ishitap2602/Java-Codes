package com.test.model;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.dao.CustomerDao;
import com.test.dao.DBConfig;

public class CustomerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		CustomerDao cdao = ctx.getBean(CustomerDao.class);
		Customer obj1 = new Customer();
		obj1.setC_first_name("IShita");
		obj1.setC_last_name("Patel");
		obj1.setC_location("Bangalore");
		
//		cdao.createCustomer(obj1);
		List<Customer>list = cdao.getAllCustomers();
		 list.forEach(System.out::println);
//			
		
		
	}

}
