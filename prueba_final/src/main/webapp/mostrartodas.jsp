<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Ciudad,service.CiudadesService,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MostrarTodas</title>
</head>
<body>
<%-- acceder a las ciudades --%>
<%
CiudadesService service = new CiudadesService();
List<Ciudad> ciudades = service.verTodas(); 
%>
<h1>Lista de ciudades</h1>
<%for (Ciudad c : ciudades) {%>
    <h2><%=c.getNombre() %> -- <%=c.getTemperatura() %> </h2>
    <br><br> 
<%} %>
<a href="menu.html">Menú</a>
</body>
</html>