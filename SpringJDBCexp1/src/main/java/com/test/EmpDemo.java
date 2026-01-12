package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO empdao = ctx.getBean("edao",EmployeeDAO.class);
		Employee emp = new Employee();
		emp.setE_name("Ishita");
		emp.setE_cmp("Mphasis");
		emp.setE_city("Mumbai");
		empdao.insertEmployee(emp);
		
		//empdao.createEmployee(emp);
		//Employee emp1 = new Employee(50, "Jay", "Infosys", "Hyderabad");
		//empdao.updateEmployee(emp1);
		//emp1.setId(5);
		//empdao.deleteEmployee(emp1);
		//List<Employee> empdata = empdao.getAllEmployees();
		//empdata.forEach(System.out::println);
		System.out.println("Employee data updated");
		
	}

}
