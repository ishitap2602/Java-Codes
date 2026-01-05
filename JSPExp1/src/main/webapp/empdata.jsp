<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EMPLOYEE DATA</h1>

<jsp:useBean id="emp" class="com.test.Employee"></jsp:useBean>
<jsp:setProperty property="*" name="emp"/>

ID:<jsp:getProperty property="id" name="emp"/>
Name:<jsp:getProperty property="name" name="emp"/>
Company:<jsp:getProperty property="cmp" name="emp"/>
</body>
</html>