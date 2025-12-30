package com.FileStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "team.txt";
		
		try(ObjectInputStream or = new ObjectInputStream(new FileInputStream(path))){
			List<PlayersData> data = (List<PlayersData>)or.readObject();
			
			for(PlayersData dt:data) {
				System.out.println(dt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
