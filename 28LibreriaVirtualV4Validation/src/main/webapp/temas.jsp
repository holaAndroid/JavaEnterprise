<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Tema,java.util.List" %>
<%@taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Temas</title>
</head>
<body>
<center>
<h1>Seleccione Tema</h1>
<br/>
<form action="Controller?option=doLibros" method="POST">
<select name="idTema">
  <option value="0">-Todos-</option>
  <c:forEach var="t" items="${requestScope.temas}">
  <option value="${t.idTema}">${t.tema}</option>
  </c:forEach>
</select>
<br/><br/>
<input type="submit" value="Ver Libros"><br>
<%-- <a href="Controller?option=toLogin">Inicio</a> --%> 
</form>
</center>
</body>
</html>