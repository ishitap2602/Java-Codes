package com.FileStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class SerialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <PlayersData> data = Arrays.asList(new PlayersData(1, "Ishita", "Good", "Mumbai"),
				new PlayersData(2, "Jay", "Average", "Pune"),
				new PlayersData(3, "Vidhan", "Gandu", "Bangalore"));
		
		String path = "team.txt";
		
		try(ObjectOutputStream ow = new ObjectOutputStream(new FileOutputStream(path))){
			ow.writeObject(data);
			ow.flush();
			System.out.println("Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
