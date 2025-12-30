package com.FileStream;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <String> data = Arrays.asList("Ishita", "Jay", "Vidhan");
		String path = "data.txt";
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))){
			data.stream().forEach(x -> {
				try {
					bw.write(x);
					bw.newLine();
				}
				catch(Exception ie) {
					ie.printStackTrace();
				}
			});
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
