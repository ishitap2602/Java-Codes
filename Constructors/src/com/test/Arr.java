package com.test;
import java.util.*;
public class Arr {

	public static void main(Strings1[] args) {
		// TODO Auto-generated method stub
		String names[] = {"Ishita", "Jay","Sahana", "Vidhan", "Neha"};
		Arrays.sort(names);
		
		System.out.println(names.toString());
		
		for(String dt : names) {
			System.out.println(dt);
		}
		
		List<String> list = Arrays.asList(names);
		list.forEach(x->System.out.println(x));

		
		
	}

}
