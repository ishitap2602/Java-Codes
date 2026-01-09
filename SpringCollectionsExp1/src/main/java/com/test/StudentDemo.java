package com.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigStudent.class);
		Student std1=ctx.getBean("getSetterObj",Student.class);
		std1.setId(112);
		std1.setName("Vidhan");
		std1.setSkills(Arrays.asList("Java","Gym", "Cooking"));
		std1.setCollege("IIM Banglore");
		
		Student s2 = ctx .getBean("getConstObj", Student.class); 
 
		System.out.println("setter injection");
		System.out.println(std1);
		System.out.println("constructor injection");
		System.out.println(s2);
 
 
	}

}
