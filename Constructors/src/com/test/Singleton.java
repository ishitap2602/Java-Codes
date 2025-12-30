package com.test;
class SingletonTest{
	public static SingletonTest obj;
	
	private SingletonTest() {
		
	}
	
	public static SingletonTest getInstance() {
		if(obj == null) {
			synchronized(obj) {
				if(obj==null) {
					obj = new SingletonTest();
				}
			} //double checking singleton concept for multithreading
			obj = new SingletonTest();
		}
		return obj; //lazy loading example i.e after giving request
	}
}
public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonTest obj1 = SingletonTest.getInstance();
		SingletonTest obj2 = SingletonTest.getInstance();
		
		System.out.println(obj1.hashCode()+ " "+ obj2.hashCode());

	}

}
