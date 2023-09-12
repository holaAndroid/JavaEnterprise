<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado libros</title>
</head>
<body>
<%-- --%> 
<center>
<h1>Listado de libros</h1><br>
<div text-align="center">
<table border=1 >
<tr>
	<th>Titulo</th>
	<th>Autor</th>
	<th>Precio</th>
	<th></th>
	<th></th>
</tr>
<c:forEach var="l" items="${requestScope.libros}">
	<tr>
	<td>${l.titulo}</td>
	<td>${l.autor}</td>
	<td>${l.precio}</td>
	<td><a href="Controller?option=doAgregar&isbn=${l.isbn}>&idTema=${param.idTema}">Añadir</a></td>
	<td><form action="Controller?option=doAgregar" method="post">
			<input type="hidden" name="isbn" value="${l.isbn}">
			<input type="hidden" name="idTema" value="${param.idTema}">
			<input type="submit" value="Añadir"></td></form>
	</tr>
</c:forEach>
</table>
</div>
<br/>
<c:if test="${!empty sessionScope.carrito}">
<h1>Carrito</h1>
<table border="1"> 
	<tr>
		<th>Título</th>
		<th>Autor</th>
		<th>Precio</th>
		<th></th>
	</tr>
<c:forEach var="carrito" items="${sessionScope.carrito}" varStatus="i">
	<tr>
		<td>${carrito.titulo}</td>
		<td>${carrito.autor}</td>
		<td>${carrito.precio}</td>
		<td><form action="Controller?option=doEliminar" method="post">
			<input type="hidden" name="position" value="${i.index}">
			<input type="hidden" name="idTema" value="${param.idTema}">
			<input type="submit" value="Eliminar">
			</form>
		</td>
		</tr>
	</c:forEach>
</table>
</c:if>
<form action="Controller?option=doVenta" method="POST">
	<input type="hidden" name="idTema" value="{param.idTema}">
 	<input type="submit" value="Comprar">
</form>
<form action="Controller?option=doVaciarCarrito" method="POST">
	<input type="hidden" name="pos" value="${i.index}">
	<input type="hidden" name="idTema" value="${param.idTema}">
 	<input type="submit" value="Limpiar Carrito">
</form>
<br/><br/>
	
<br><br/>
<a href="Controller?option=doTemas">Otros temas</a>
</center>
</body>
</html>