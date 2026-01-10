package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		User obj = ctx.getBean("user", User.class);
		System.out.println(obj);
		
		ExpressionParser exp = new SpelExpressionParser();
		//String str = "java";
		Expression ex = exp.parseExpression("'this is simple string literal example'");
		String str = ex.getValue(String.class);
		System.out.println("Literal Exp: "+str);
		Expression exp1 = exp.parseExpression("'MLA Bengaluru'".toUpperCase());
		String upr = exp1.getValue(String.class);
		System.out.println("String Uppercase Method: "+upr);
		Expression exp2 = exp.parseExpression("5*5");
		Integer a = exp2.getValue(Integer.class);
		System.out.println("Numerical data: "+a);
		
		
		
	}
 
	
}


