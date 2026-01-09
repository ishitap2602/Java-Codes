package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory bn = new ClassPathXmlApplicationContext("beans.xml");
		//Employee obj = bn.getBean("emp",Employee.class);
		System.out.println("Setter Injection");
		Customer obj1 = (Customer)bn.getBean("cust");
		System.out.println(obj1);
			
		System.out.println("Constructor data");
		Customer obj2 = bn.getBean("cust1",Customer.class);
		System.out.println(obj2);
		
		
	}

}
