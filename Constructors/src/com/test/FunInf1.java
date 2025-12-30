package com.test;
@FunctionalInterface
interface If7{
	void userData();
}
public class FunInf1 {

	public static void main(Strings1[] args) {
		// TODO Auto-generated method stub

		If7 obj = new If7() {
			@Override
			public void userData() {
				System.out.println("Overrided");
			}
		};
		obj.userData();
		new If7() {
			@Override 
			public void userData() {
				System.out.println("Namelesss obj");
			}
		}.userData();
	}

}
