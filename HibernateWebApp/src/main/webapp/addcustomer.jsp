<%@page import="com.test.CustomerDAO"%>
<%@page import="com.test.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD CUSTOMER</title>
</head>
<body>
 
	<!--  
	<jsp:useBean id="cst" class="com.test.Customer"></jsp:useBean>
	
	<jsp:setProperty property="firstName" name="cst"/>
	<jsp:setProperty property="lastName" name="cst"/>
	<jsp:setProperty property="location" name="cst"/>
	-->
	
	<%
		String fname= request.getParameter("firstName");
		String lname= request.getParameter("lastName");
		String loc= request.getParameter("location");
		
		Customer obj = new Customer();
		obj.setFirstName(fname);
		obj.setLastName(lname);
		obj.setLocation(loc);
		
		CustomerDAO.addCustomer(obj);
		out.println("<h3>Successfully added Customer</h3>");
	%>
	
	
</body>
</html>
 