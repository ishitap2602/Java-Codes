package com.test;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementat
 */
@WebFilter("/Login")
public class MyFilter extends HttpFilter implements Filter {
       
   
	public void destroy() {
		System.out.println("destroy() filter");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	System.out.println("before servlet");
		chain.doFilter(request, response);
		
		System.out.println("after servlet");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() filter");
	}

}
