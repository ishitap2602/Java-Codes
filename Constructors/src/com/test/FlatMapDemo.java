package com.test;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Integer> list1=Arrays.asList(10,20,30);
		List<Integer> list2=Arrays.asList(100,200,300);

		List<List<Integer>> cmbnd = Arrays.asList(list1, list2);
		System.out.println(cmbnd);
		//List<Integer> fltmp = cmbnd.stream().flatMap(List::Stream).toList();
		//System.out.println(fltmp);
		
	}

}
