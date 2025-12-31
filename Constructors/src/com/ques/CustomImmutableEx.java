//Create a Custom Immutable class with example
 
package com.ques;
 
final class Person{
	private final String name ="Jay";
	private final int age = 22;
	
	private String getName() {
		return name;
	}
	private int getAge() {
		return age;
	}
	public void getDetails() {
		System.out.println(getName());
		System.out.println(getAge());
	}
	
}
 
public class CustomImmutableEx {
 
	public static void main(String[] args) {
		Person p = new Person();
		p.getDetails();
 
	}
 
}
 
 