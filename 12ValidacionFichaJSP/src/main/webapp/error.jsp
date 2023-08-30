<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error JSP</title>
</head>
<body>
		<% 
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		%>
		<h1>Error, la combinación <%=usuario %> y <%=pwd %> no es correcta</h1>
		<br><a href='login.html'>Volver</a>
		
</body>
</html>