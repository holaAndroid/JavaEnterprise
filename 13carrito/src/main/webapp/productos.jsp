<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="service.Carrito,model.Producto,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%-- Leer Carrito --%>
<% 
Carrito carrito = (Carrito) session.getAttribute("carrito");
if (carrito!=null){
	List<Producto> productos = (List<Producto>)carrito.getProductos();

%>
<table border=1>
<tr><th>Producto</th></tr>
<%-- Recorremos la lista en el for --%>
	<% for (Producto p:productos) {%>
		<tr><td><%=p.getNombre() %></td></tr>
	<%} %>
</table>
<% }else { %>
<h2>El carrito está vacío</h2>
<% } %>
<br>
<a href="inicio.html">Inicio</a>
<a href="Desconexion">Desconexión</a>
</center>
</body>
</html>