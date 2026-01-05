package com.test;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;
 
@WebServlet("/Login")

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("from servlet");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String usr = request.getParameter("user");

		String pass = request.getParameter("pwd");

		HttpSession session = request.getSession();
		session.setAttribute("info", usr);
		ServletContext ctx = getServletContext();
		
		int t = (int)ctx.getAttribute("tusers");
		int c = (int)ctx.getAttribute("cusers");
		
		out.println("<h3> Total users: "+t+"</h3>");
		out.println("<h3>Current users: "+c+"</h3>");
		
	out.println("<a href ='Logout'>Logout</a>");	
		//if(usr.equals("admin") && pass.equals("a123")) {
//
//				RequestDispatcher rd = request.getRequestDispatcher("home.html");
//
//				rd.forward(request, response);					//wont include current page data
//
//		}else {
//
//			out.println("<center><font color = 'red'>Invalid Credentials</font></center>");
//
//			RequestDispatcher rd = request.getRequestDispatcher("login.html");
//
//			rd.include(request, response);					//include current page data+display requested page
//
//		}

	}
 
}

 