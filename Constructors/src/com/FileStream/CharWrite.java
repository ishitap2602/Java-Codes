package com.FileStream;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class CharWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (FileWriter fw = new FileWriter("chartest.txt");
				BufferedWriter bw = new BufferedWriter(fw)){
					String msg = "This is Sample char stream read and write operations.";
					bw.write(msg);
					bw.flush();
					System.out.println("Done!");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
	}

}
