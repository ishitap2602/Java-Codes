package com.test1;

//import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Login() {
        // TODO Auto-generated constructor stub
    	
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String usr = request.getParameter("user");
			String pas = request.getParameter("pwd");
			String sql = "select u_name, u_password from user1 where u_name = '"+usr+"' ";
			User obj = new User();
			Statement stmt = null;
			
			try {
				stmt = DBconnections.getCon().createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					obj.setUsername(rs.getString(1));
					obj.setPassword(rs.getString(2));

				}
				
				if(usr.equals(obj.getUsername()) && pas.equals(obj.getPassword())) {
					out.println("<h3>Login Success</h3>");
				}
				else {
					out.println("<h3>Invalid credentials</h3>");

				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}

}
