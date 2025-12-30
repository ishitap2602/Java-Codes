package com.test;

import java.util.Arrays;
import java.util.List;

public class Stream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Sky", "Kholi", "Rohit", "Dhoni");
		
		names.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);
		
//		names.stream().flatMap(String::toLowerCase).forEach(System.out::println);
		
		List<Integer> nums = Arrays.asList(2,3,4,5,6,7,8,9);
		nums.stream()
		.map(x->x*x)
		.forEach(System.out::println);
		
		
		
		
		
		
	}

}
