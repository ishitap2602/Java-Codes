<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contentPath} /userpage">FSD USER</a> |
<a href="${pageContext.request.contentPath} /adminpage">FSD ADMIN</a> |
<a href="javascript:document.getElementById ('logout') .submit()">Logout</a> |

<c:url value="/logout" var = "logoutUrl"></c:url>
<form id="logout" action="${logoutUrl}" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<c:if test="${pageContext.request.userPrincipal.name !=null }">
<a href="javascript:document.getElementById('logout').submit()">Logout</a></c:if>


</body>
</html>