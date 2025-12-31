package com.ques;

import java.util.Arrays;
import java.util.List;
 
public class UnboundedCustomerData {
	public static List<?> UnboundedData(List<?> firstName) {
		return Arrays.asList(firstName);
	}
 
	public static void main(String[] args) {
		List<String> firstName = Arrays.asList("Jay", "Vidhan", "Riddhi", "Joshua" ,"Ayush", "Jayden", "Rohit", "Ishita", "Parth", "Rudra", "Akash"," Alina", "Brother", "Cat", "Jockey");
		System.out.println(UnboundedData(firstName));

		List<String> fltr = 
			firstName.stream()
			.filter(x -> x.startsWith("A") && x.endsWith("h"))
			.toList();
		System.out.println(fltr);
	}
 
}
