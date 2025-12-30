package com.test;
@FunctionalInterface

interface FunInf {

	String greetUser(String string);
	
	static void cat() {
		System.out.println("Funinf cat()");
	}
	default void dog() {
		System.out.println("Funinf Dog()");
		fox();
	}
	private void fox() {
		System.out.println("Funinf Fox()");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FunInf obj = (String msg) -> {
			System.out.println("Funinf overried");
			return msg;
		};
		System.out.println(obj.greetUser("Hii Ishita.."));
	}

}
