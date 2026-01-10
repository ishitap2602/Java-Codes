package com.test.spring.aspect;

	import org.aspectj.lang.annotation.Aspect;	 
	import org.aopalliance.intercept.Joinpoint;
	import org.aspectj.lang.annotation.After;
	import org.aspectj.lang.annotation.AfterReturning;
	import org.aspectj.lang.annotation.AfterThrowing;
	import org.aspectj.lang.annotation.Aspect;
	@Aspect
	public class EmployeeAfterAspect {

	@After("args(name)")
	public void logStringArguments(String name)
	{
		System.out.println("Running After Advice String argument Passed: "+name);
	}
	 
	@AfterThrowing("within(com.test.spring.model.Employee")
	public void logException(Joinpoint joinpoint)
	{
		System.out.println("Exception thrown in employee class : "+joinpoint.toString());
	}
	
	@AfterReturning(pointcut="execution(*getName())",returning="returnString")
	public void getNameResturnAdvice(String returnString) {
		System.out.println("getNameReturning advice executed: "+returnString);
	}
	
}
	 
	 

