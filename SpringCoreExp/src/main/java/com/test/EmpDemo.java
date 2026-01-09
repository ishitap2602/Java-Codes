package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory bn = new ClassPathXmlApplicationContext("beans.xml");
		//Employee obj = bn.getBean("emp",Employee.class);
		System.out.println("Setter Injection");
		Employee obj1 = (Employee)bn.getBean("emp");
		System.out.println(obj1);
			
		System.out.println("Constructor data");
		Employee obj2 = bn.getBean("emp1",Employee.class);
		System.out.println(obj2);

				
		
	}

}
