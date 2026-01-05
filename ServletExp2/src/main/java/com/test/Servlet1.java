package com.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext cxt = getServletContext();
		
		String ct = cxt.getInitParameter("city");
		String st = cxt.getInitParameter("state");

		String data = ct+""+st;
		out.println("<h2> from servlet1: "+data+"</h2>");
		cxt.setAttribute("info", data);
		
		out.println("<a href='Servlet2'> go to next </a>");
		
		ServletConfig cfg = getServletConfig();
		String usr = cfg.getInitParameter("user");
		String pas = cfg.getInitParameter("pwd");
		
		out.println("hii");
		out.print("byee");
		out.println("<h2> from servlet1: "+"user"+"+pas </h2>");

		
	}

}
