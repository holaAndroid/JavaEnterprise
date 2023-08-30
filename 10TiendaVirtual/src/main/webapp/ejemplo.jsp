<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<%-- esto es un comentario --%>
	<% for (int i=1; i<=6; i++) { %>
	<h<%=i%>>Bienvenido a JSP<%=i %></h<%=i%>>
	<%}
		for (int i=6; i>0; i--) { %>
	<h<%=i %>>Bienvenido a JSP<%=i %></h<%=i %>>
	<% } %>
	</center>
</body>
</html>