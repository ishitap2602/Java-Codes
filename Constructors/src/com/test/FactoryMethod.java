package com.test;
 
class Book{
	static int pincode = 234234;
	int atmpin = 3030;
	
	public Book() {
		System.out.println("Constructor");
	}
	
	public static Book getObj() {
		System.out.println("Factory method");
		return new Book();
	}
	
	static {
		System.out.println("Static block " + pincode );
	}
	{
		System.out.println("Instance " + pincode + " "+atmpin);
	}
}
public class FactoryMethod {
	static{
		System.out.println("Static Main ");
	}
	public static void main(Strings1[] args) {
		System.out.println("main");
		FactoryMethod b1 = new FactoryMethod();
		
		Book b2 = Book.getObj();
		
		FactoryMethod b3 = b1;
	}
 
}
 
 