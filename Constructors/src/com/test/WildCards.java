package com.test;

import java.util.Arrays;
import java.util.List;

public class WildCards {
	private static double add(List<? extends Number> list) {
		double a = 0.0;
		for(Number n : list) {
			a = n.doubleValue();
			//a += a;
		}
	return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list1 = Arrays.asList(12,13,14);
		add(list1);
		
		List<Double> list2 = Arrays.asList(1.2,1.3,1.4);
		add(list2);
		
		lowerBounded(list1);
		unboundedData(list2);
		
		
	}
	public static void unboundedData(List<Double> list2) {
		// TODO Auto-generated method stub
		System.out.println(list2);

	}
	public static void lowerBounded(List<Integer> list1) {
		// TODO Auto-generated method stub
		System.out.println(list1);
	}
}