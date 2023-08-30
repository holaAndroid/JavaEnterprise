<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Recupero el paramétro  http://localhost:8080/11_jsp/saludo.jsp?nombre=Miranda&numero=7 --%>
	<% 
	String nombre = request.getParameter("nombre"); 
	int numero = Integer.parseInt(request.getParameter("numero")); 
	for (int i=1;i<=numero;i++){ %>
	<h<%=i%6+1 %>>Saludo JSP <%=nombre %> <%=numero %></h<%=i%6+1 %>>
	<% } %>
</body>
</html>
