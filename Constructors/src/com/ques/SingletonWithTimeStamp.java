package com.ques;

import java.time.LocalDateTime;

class Singleton{
	private static Singleton obj;
	private final LocalDateTime createdAt;
	private Singleton() {
		this.createdAt = LocalDateTime.now();
	}
	
	public static synchronized Singleton getInstance() {
		if(obj == null) {
			return new Singleton();
		}
		return obj;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
 
public class SingletonWithTimeStamp {
 
	public static void main(String[] args) {
		Singleton obj = Singleton.getInstance();
		System.out.println(obj.getCreatedAt());
	}
 
}
