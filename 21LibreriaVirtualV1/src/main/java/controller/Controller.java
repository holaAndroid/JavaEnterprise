package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String option = request.getParameter("option");
	String urlVista = "login.html";
	switch (option) {
		case "doValidar":
			request.getRequestDispatcher("ValidarAction")
			.include(request, response);
			boolean valido = (boolean)request.getAttribute("valido"); // getAtributo siempre devuelve String
			urlVista = (valido? "bienvenido.html":"noencontrado.jsp");
			break;
		case "doRegistrar": 
			request.getRequestDispatcher("RegistrarAction")
			.include(request, response);
			urlVista="login.html";
			break;
		case "toLogin":
			urlVista="login.html";
			break;
		case "toRegistro":
			urlVista="registro.html";
			break;
		
	}
	request.getRequestDispatcher(urlVista)
	.forward(request, response);
	}
}
