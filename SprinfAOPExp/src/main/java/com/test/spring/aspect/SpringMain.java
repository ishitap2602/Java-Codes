package com.test.spring.aspect;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.test.spring.service.EmployeeService;
 
public class SpringMain {
    public static void main(String[] args) {
        // Make sure this filename matches the actual location on the classpath
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
 
        // Prefer this typed getBean to catch mismatches earlier
        EmployeeService service = ctx.getBean("employeeService", EmployeeService.class);
 
        String name = service.getEmployee().getName();
		
		System.out.println("AOP FROM MAIN CLASS : " + name);
		
		service.getEmployee().setName("Ishita");
		
		service.getEmployee().throwException();
     }
}
 
 