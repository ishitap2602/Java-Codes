package com.test;
import java.util.Scanner;
public class Validateuser {
	  public static void main(String[] args) {
	String uname="sahana";
	String password="password";
	Scanner sc=new Scanner(System.in);
	try {
		
		String user=sc.next();
		String pword=sc.next();
		validate(uname,password,user,pword);
	}
	catch(Exception e)
	{
		System.out.println("An error occured");
	}
	  }
  public static void validate(String uname,String password,String user,String pword)
  {
	  if(uname.equals(user)&&password.equals(pword))
			  {
		         
			  }
  }
  
}
 
 