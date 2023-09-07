<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Tema,java.util.List" %>
<%--
<%@ page import="model.Tema" %>
<%@ page import="java.util.List" %>
--%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Temas</title>
</head>
<body>
 
<%
List<Tema> temas= (List<Tema>) request.getAttribute("temas");
%>
<center>
<h1>Seleccione Tema</h1>
<br/>
<form action="Controller?option=doLibros" method="POST">
<select name="idTema">
  <option value="0">-Todos-</option>
  <%for(Tema t: temas) { %>
  <option value="<%=t.getIdTema()%>"><%=t.getTema()%></option>
  <% } %>
</select>
<br/><br/>
<input type="submit" value="Ver Libros"><br>
<%-- <a href="Controller?option=toLogin">Inicio</a> --%> 
</form>
</center>
</body>
</html>