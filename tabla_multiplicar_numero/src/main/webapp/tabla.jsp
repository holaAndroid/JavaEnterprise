<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Tabla multiplicar </title>
<link rel="stylesheet" href=inicio.css>
</head>
<body>
<% int n = Integer.parseInt(request.getParameter("numero")); %>
<h1>Tabla de multiplicar de numero <%=n %></h1>
<table border=1>
<% for (int i=1;i<=10;i++){%>
	<tr>
		<td><%=i%>x<%=n %></td>
		<td><%=i*n %></td>
	</tr>
<%} %>
</table>
<a href='inicio.html'>Inicio</a>
</body>
</html>