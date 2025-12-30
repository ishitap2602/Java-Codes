package com.FileStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteWrite {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("src/bytetest.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		String msg = "This is simple byte stream write and read operations. ";
		bos.write(msg.getBytes());
		bos.flush();
		System.out.println("Done!");
		
		
	}

}
