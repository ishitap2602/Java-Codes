package com.test;

public class Strings1 {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		String a = "hello";
		String b = "hello"; 
		String e = "java"; 

		String c = new String ("hello");
		String d = new String ("hello");

		System.out.println(a==b);
		System.out.println(a==e);
		System.out.println(a==c);
		System.out.println(b==d);
		System.out.println(c==d);
		
		System.out.println(b.equals(d));
		a.concat("byee");
		System.out.println(a);

	}

}
