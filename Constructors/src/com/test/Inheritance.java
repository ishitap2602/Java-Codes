package com.test;

class C{
	public void show() {
		System.out.println("Top most Parent");
	}
}
class D extends C{
	public void cat() {
		System.out.println("Child 1");
	}
}
class E extends D{
	public void dog() {
		System.out.println("Child 2");
	}
}
class F extends E{
	public void cow() {
		System.out.println("Last child");
	}
}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F obj = new F();
		obj.cat();
		obj.dog();
		obj.cow();

	}

}
