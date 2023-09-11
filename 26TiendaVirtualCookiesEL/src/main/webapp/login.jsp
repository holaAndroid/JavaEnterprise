<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
String fechaUltima="";
Cookie[] cookies=request.getCookies();
if (cookies!=null){
	for(Cookie ck:cookies){
		if (ck.getName().equals("fechaultima")){
			fechaUltima=ck.getValue();
		}
	}
}
if (!fechaUltima.equals("")){--%>
	
<%--<% } %>--%>
	<center>
	<h3>Tú última visita fue ${cookie.fechaultima.value}</h3>
		<img alt="sin imagen" src="imgGoogle.png">
		<form action="Login" method="POST">
			Usuario:<input type="text" name="usuario"><br>
			Password:<input type="password" name="pwd"><br>
			<input type="submit" value="Entrar">
		</form>
	
	</center>
</body>
</html>