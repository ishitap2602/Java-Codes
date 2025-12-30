package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> nums = Arrays.asList(3,5,6,7);
		Optional<Integer> dt = nums.stream().findAny();
		
		if(dt.isPresent()) {
			System.out.println(dt.get());
		}
		else {
			System.out.println("No Data");
		}
		
		
		List<String> names = Arrays.asList("Sky", "Kholi", "Rohit", "Dhoni");
		Optional<String> rslt = names.stream().findFirst();
		
		if(dt.isPresent()) {
			System.out.println(rslt.get());
		}
		else {
			System.out.println("No Data Again");
		}
	}

}
