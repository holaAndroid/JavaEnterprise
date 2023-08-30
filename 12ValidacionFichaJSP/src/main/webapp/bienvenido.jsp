<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Ficha"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
		<% 
		 String usuario = request.getParameter("usuario");
		 Ficha ficha = (Ficha)request.getAttribute("ficha");
		 String email = ficha.getEmail();
		 int edad = ficha.getEdad();
		%>
			<h1>Bienvenido <%=usuario %></h1>
	        <p>Tu email es: <%=email %></p>
	        <p>Tu edad es: <%=edad %></p>
	        <br><a href='login.html'>Volver</a>
</body>
</html>