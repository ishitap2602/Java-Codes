package com.test;

class Parent1{
	public void greetUser() {
		System.out.println("Parent");
	}
}
class Child1 extends Parent1{
	public void sendMsg(String msg) {
		greetUser();
		System.out.println("Calling parent Method" +msg);
	}
	
	@Override
	public void greetUser() {
		System.out.println("Overrided");
		sendMsg("Hii Factory Method");
	}
	public static Parent1 getInstance() {
		return new Parent1();
	}
}
public class FactoryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
