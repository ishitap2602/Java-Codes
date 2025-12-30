package com.FileStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/bytetest.txt";
		
		try(Stream<String> lines = Files.lines(Paths.get(path))){
			lines.filter(x -> x.startsWith("T"))
			.map(String::toUpperCase);
			//.forEach(System.out::println());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
