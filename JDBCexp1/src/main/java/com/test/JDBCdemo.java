package com.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCdemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/mladec";
		String user = "root";
		String pass = "root@39";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();		
		String sql = "insert into book1 values(1, 'Java', 250)";
		
		stmt.addBatch("insert into book1 values(2, 'Python', 300)");
		stmt.addBatch("insert into book1 values(3, 'Spring', 350)");
		stmt.addBatch("insert into book1 values(4, 'Angular', 400)");
		stmt.addBatch("insert into book1 values(5, 'React', 450)");
		
		
		//stmt.executeBatch();
		//stmt.execute("Create table book1 (b_id int, b_name varchar(50), b_price int)");
		String sql1 = "select * from book1";
		ResultSet rs = stmt.executeQuery(sql1);
		
		while(rs.next()) {
			System.out.println("Id: "+rs.getInt(1)+" Name: "+rs.getString(2)+ " Price: "+rs.getInt(3));
		}
		con.close();
		
		System.out.println("Done");
		
	}

}
 