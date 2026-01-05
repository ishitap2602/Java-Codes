package com.test1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnections {

	private static Connection con = null;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mladec";
	private static String user = "root";
	private static String pas = "root@39";
	
	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pas);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return con;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
