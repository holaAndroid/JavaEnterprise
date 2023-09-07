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
	<th></th>
	<th></th>
</tr>
<%for (Libro l: libros) {  %>
	<tr>
	<td><%=l.getTitulo() %></td>
	<td><%=l.getAutor() %></td>
	<td><%=l.getPrecio() %></td>
	<td><a href="Controller?option=doAgregar&isbn=<%=l.getIsbn()%>&idTema=<%=request.getParameter("idTema")%>">Añadir</a></td>
	<td><form action="Controller?option=doAgregar" method="post">
			<input type="hidden" name="isbn" value="<%=l.getIsbn()%>">
			<input type="hidden" name="idTema" value="<%=request.getParameter("idTema")%>">
			<input type="submit" value="Añadir"></td></form>
	</tr>
	
<%} %>
</table>
</div>
<br/>
<%List<Libro> carrito =(List<Libro>) session.getAttribute("carrito"); 
if (carrito!=null && !carrito.isEmpty()) {%>
<h1>Carrito</h1>
<table border="1"> 
	<tr>
		<th>Título</th>
		<th>Autor</th>
		<th>Precio</th>
		<th></th>
	</tr>
	<%for(int i=0;i<carrito.size();i++){%>
	<tr>
		<td><%=carrito.get(i).getTitulo()%></td>
		<td><%=carrito.get(i).getAutor()%></td>
		<td><%=carrito.get(i).getPrecio()%></td>
		<td><form action="Controller?option=doEliminar" method="post">
			<input type="hidden" name="position" value="<%=i%>">
			<input type="hidden" name="idTema" value="<%=request.getParameter("idTema")%>">
			<input type="submit" value="Eliminar">
			</form>
		</td>
		</tr>
	<% } %>
</table>
<form action="Controller?option=doVenta" method="POST">
	<input type="hidden" name="idTema" value="<%=request.getParameter("idTema")%>">
 	<input type="submit" value="Comprar">
</form>
<form action="Controller?option=doVaciarCarrito" method="POST">
	<input type="hidden" name="idTema" value="<%=request.getParameter("idTema")%>">
 	<input type="submit" value="Limpiar Carrito">
</form>
<%} %>
<br/><br/>
	
<br><br/>
<a href="Controller?option=doTemas">Otros temas</a>
</center>
</body>
</html>