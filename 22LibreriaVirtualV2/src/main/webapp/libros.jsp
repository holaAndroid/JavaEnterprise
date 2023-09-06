<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.Libro, model.Tema"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado libros</title>
</head>
<body>
<%-- --%> 
<%
List<Libro> libros= (List<Libro>) request.getAttribute("libros");
%>
<center>
<h1>Listado de libros</h1><br>
<div text-align="center">
<table border=1 >
<tr>
	<th>Titulo</th>
	<th>Autor</th>
	<th>Precio</th>
</tr>
<%for (Libro l: libros) {  %>
	<tr>
	<td><%=l.getTitulo() %></td>
	<td><%=l.getAutor() %></td>
	<td><%=l.getPrecio() %></td>
	</tr>
<%} %>
</table>
</div>
<br><a href="Controller?option=doTemas">Otros temas</a>
</center>
</body>
</html>