<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1> Login Success!!</h1> 

<%
String usr=(String)session.getAttribute("info");

String dt=(String)application.getAttribute("userinfo");

out.println("SESSION OBJECT DATA:"+usr);
out.println("<br><br>Context Object DATA:"+dt);
%>
</body>
</html>