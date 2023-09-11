<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.Contacto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado Contactos</title>
</head>
<body>
<%-- --%> 
<%
List<Contacto> contactos= (List<Contacto>) request.getAttribute("contactos");
%>
<center>
<h1>Listado de contactos</h1><br>
<div text-align="center">
<table border=1 >
<tr>
	<th>Nombre</th>
	<th>Email</th>
	<th>Edad</th>
</tr>
<%for (Contacto c: contactos) {  %>
	<tr>
	<td><%=c.getNombre() %></td>
	<td><%=c.getEmail() %></td>
	<td><%=c.getEdad() %></td>
	</tr>
<%} %>
</table>
</div>
<br><a href="home.html">Inicio</a>
</center>
</body>
</html>