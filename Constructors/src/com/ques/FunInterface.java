package com.ques;

@FunctionalInterface
interface FunInf
{
	String greetUser(String msg);
	
	static void cat()
	{
		System.out.println("funinf cat()");
	}
	
	default void dog()
	{
		System.out.println("funinf dog()");
		fox();
	}
	
	private void fox()
	{
		System.out.println("funinf fox()");
	}
}
 
public class FunInterface {
	
	public static void main(String[] args) {
		
		//JDK 8 feature
		
		FunInf obj = (String msg) -> {
			
			System.out.println("funinf overrided");
			
			return msg;
		};
		
		System.out.println(obj.greetUser("Hi hello..."));
		
	}
}
 
