package com.test;

public class StringBuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="java";
		StringBuffer sb = new StringBuffer(str1);
		str1.concat("25 I");
		System.out.println(str1);
		
		sb.append("25 I");
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		
	}

}
