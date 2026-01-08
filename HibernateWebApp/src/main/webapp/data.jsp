<%@page import="com.test.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String i = request.getParameter("id");
    	System.out.println("YOUR Id: "+i);
    	
    	if(i.equals("")){
    		out.println("THE GIVEN ID IS NULL / YOUR DIDN'T ENTER ID");
    	}
    	
    	int id = Integer.parseInt(i);
    	
    	Customer cst = Customer.fetchCustomerById(id);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER</title>
</head>
<body>
	<table border="1" align="center">
		<thead>
			<tr>
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td><%= cst.getId() %></td>
			<td><%= cst.getFirstName() %></td>
			<td><%= cst.getLastName() %></td>
			<td><%= cst.getLocation() %></td>
		</tr>
		</tbody>
	</table>
</body>
</html>