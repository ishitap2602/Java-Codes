<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--  scriplet tag -->
 <%
 String usr=request.getParameter("user");
 String pas =request.getParameter("pwd");
 
 session.setAttribute("info",usr);
 
 application.setAttribute("userinfo",usr);
 if(usr.equals("admin") && pas.equals("java")){
	 %>
	 <jsp:forward page="success.jsp"></jsp:forward>
	 <% 
 }else{
	 out.println("invalid credentials");
	 %>
	 <jsp:include page="login.jsp"></jsp:include>
	 <%
 }
 %>
</body>
</html>