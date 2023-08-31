<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver Likes</title>
</head>
<body>
	<%
	Integer contador = (Integer)application.getAttribute("contador"); 
	if (contador!=null){%>
		<h1>Tienes <%=contador %> likes</h1>
	<% }else{%>
		<h1>Ni tú madre te da like.</h1>
	<% } %>
	<br>
	<a href="inicio.html">Inicio</a>
	<center>
	
	
	</center>

</body>
</html>