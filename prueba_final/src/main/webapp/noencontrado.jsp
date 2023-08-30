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
<% String nombre = request.getParameter("nombre"); %>
	<h1>No se han encontrado  ninguna ciudad <%=nombre %></h1> 
	<a href='menu.html'>Inicio</a>
</body>
</html>