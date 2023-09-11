<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.usuario}">
<p alingn="right">Bienvenido ${sessionScope.usuario }</p>
</c:when>
<c:otherwise>
<jsp:forward page="timeout.html"/>
</c:otherwise>
</c:choose>
<center>
<h1>Productos encontrados ${param.seccion}</h1><br>
<table border=1>
<tr><td>Nombre</td><td>Sección</td><td>Precio</td><td>Stock</td></tr>
<c:forEach var="p" items="${requestScope.respuesta}">
	<tr>
	<td>~${p.nombre}></td>
	<td>~${p.seccion}></td>
	<td>~${p.precio}></td>
	<td>~${p.stock}></td>
	</tr>
</c:forEach>
</table>
<br><a href="home.html">Inicio</a>
</center>



</body>
</html>