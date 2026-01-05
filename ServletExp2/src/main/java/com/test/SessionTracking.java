package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SessionTracking")
public class SessionTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String usr = request.getParameter("user");
			//Cookie ck = new Cookie("info", usr);
			//response.addCookie(ck); 
			
			
			HttpSession session = request.getSession();
			session.setAttribute("info", usr);
			out.println("From main page: " +usr);
			out.println("<a href = 'Logout'>Logout here</a>");
			
	 
			
		}

}
