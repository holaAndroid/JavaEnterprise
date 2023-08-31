<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String seccion = request.getParameter("seccion"); // un formulario que me mande una sección
seccion=(seccion==null ? "" : seccion);
List<Producto> productos= (List<Producto>) request.getAttribute("respuesta");
String usuario = (String) session.getAttribute("usuario");
%>
<%if (usuario!=null) { %>
<p alingn="right">Bienvenido <%=usuario %></p>
<%}else {%>
	<jsp:forward page="timeout.html"/>
<%} %> 
<center>
<h1>Productos encontrados <%=seccion %></h1><br>
<table border=1>
<tr><td>Nombre</td><td>Sección</td><td>Precio</td><td>Stock</td></tr>
<%for (Producto p: productos) {  %>
	<tr>
	<td><%=p.getNombre() %></td>
	<td><%=p.getSeccion() %></td>
	<td><%=p.getPrecio() %></td>
	<td><%=p.getStock() %></td>
	</tr>
	<%} %>
</table>
<br><a href="home.html">Inicio</a>
</center>



</body>
</html>