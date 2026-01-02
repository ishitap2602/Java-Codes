package com.example.empmgmt.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
private static final String url = "jdbc:mysql://localhost:3306/employee_db";
private static final	String username ="root";
private static final	String password ="root@39";

//Returns a new Connection. Caller is responsible to close it.

public static Connection getConnection() throws SQLException
{
	return DriverManager.getConnection(url,username,password);
}

	
}
