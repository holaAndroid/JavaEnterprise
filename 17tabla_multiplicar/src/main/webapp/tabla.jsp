<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=index.css>
</head>
<body>
<h1>Tabla de multiplicar del 1 al 10</h1><br>

<table border = 1>
<% for (int i=1;i<=10;i++){%>
<tr>
 <% for (int j =1;j<=10;j++){%> 
 <td><%=i * j %></td>
 <% }%> 
 </tr>
<% }%>
</table>
</body>
</html>