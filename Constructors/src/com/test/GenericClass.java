package com.test;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <String> data = new ArrayList();
		
		
		data.add("Prajakta");
		data.add("Ishita");
		data.add("spring");
		data.add("Php");
		
		//System.out.println(data);
		
		for(String dt:data) {
			if(dt.startsWith("P")) {
				System.out.println(dt);
			}
		}
		
		List<String> fltr = data.stream().filter(x->x.startsWith("P")).toList();
		System.out.println(fltr);
		
	}

}
