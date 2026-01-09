package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TriangleDemo {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		Triangle triangle = (Triangle) ctx.getBean("triangle");
		triangle.draw();

	}

}
