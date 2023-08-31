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
<% String seccion = request.getParameter("seccion"); %>
	<h1>No se han encontrado productos de <%=seccion %></h1> 
	<a href='home.html'>Home</a>
</body>
</html>