package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCust {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigCustomer.class);
		
		Customer c1 = ctx.getBean("getSetterObj",Customer.class);
		c1.setId(111);
		c1.setName("Jay");
		c1.setOrder("Speaker");
		c1.setOrderPrice(15000);
		
		System.out.println(c1);
		
		Customer c2 = ctx.getBean("getConstObj",Customer.class);
		System.out.println(c2);
		
		
		
		
		
	}

}
