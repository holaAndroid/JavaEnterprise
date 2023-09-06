<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoEncontrado</title>
</head>
<body>
<%-- Recupero el paramétro --%>
	<h1>El usuario <%=request.getParameter("nombre")%> 
	y la contraseña <%=request.getParameter("pwd")%> no se encuentra.</h1> 
	<a href="Controller?option=toLogin">Volver</a>
</body>
</html>