package com.test;

import java.util.stream.Stream;

public class OptionalClassDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stream<Number> strm = Stream.of(10,20,30);
		Stream<String> names = Stream.of("Sky", "Ishita", "Vidhan", "Jay");
		
		Stream.of(1,2,3).findAny().ifPresent(System.out::println);
		Stream.of("Java", "Pyton", "C++").parallel().findFirst().ifPresent(System.out::println);
		//names.close();
		System.out.println("-*-*-*-*-");
		Stream<String> names1 = Stream.of("Sky", "Ishita", "Vidhan", "Jay");

		names1.sorted().forEach(System.out::println);
		
		
		
		
		
		
		
	}

}
