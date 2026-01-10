package com.test.spring.aspect;
 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
 
@Aspect
public class EmployeeAspectPointcut {
	
@Before("getNamePointcut()")
public void loggingAdvice()
{
	System.out.println("executing logging advice on getName()");
}
@Before("getNamePointcut()")
public void secondAdvice()
{
	System.out.println("executing second advice on getName()");
}
 
@Pointcut("execution(public String getName())")
public void getNamePointcut()
{
	
}
@Before("allMethodsPointcut()")
public void allServiceMethodsAdvice()
{
	System.out.println("Before executing service model");
}
@Pointcut("within(com.test.spring.service.*)")
public void allMethodsPointcut()
{
	
}
}
 
 