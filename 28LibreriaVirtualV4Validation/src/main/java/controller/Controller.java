 package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String option = request.getParameter("option");
	String urlVista = "login.html";
	switch (option) {
		case "doValidar":
			//Valida el usuario
			request.getRequestDispatcher("ValidarAction")
			.include(request, response);
			//Creamos la sesion
			HttpSession sesion = request.getSession();
			int idCliente = (int)sesion.getAttribute("idCliente"); // getAtributo siempre devuelve String
			//Recoge la lista de temas
			request.getRequestDispatcher("TemasAction")
			.include(request, response);
			//Si es distinto de 0 es un cliente válido 
			//sino no encontrado
			urlVista = (idCliente!=0? "temas.jsp":"noencontrado.jsp");
			break;
		case "doRegistrar": 
			request.getRequestDispatcher("RegistrarAction")
			.include(request, response);
			urlVista="login.html";
			break;
		case "doLibros": 
			request.getRequestDispatcher("LibrosAction")
			.include(request, response);
			urlVista="libros.jsp";
			break;
		case "doTemas": 
			request.getRequestDispatcher("TemasAction")
			.include(request, response);
			urlVista="temas.jsp";
			break;
		case "toLogin":
			urlVista="login.html";
			break;
		case "toRegistro":
			urlVista="registro.html";
			break;		
		case "doAgregar": 
			request.getRequestDispatcher("AgregarCarritoAction")
			.include(request, response);
			request.getRequestDispatcher("LibrosAction")
			.include(request, response);
			urlVista="libros.jsp";
			break;
		case "doEliminar": 
			request.getRequestDispatcher("EliminarCarritoAction")
			.include(request, response);
			request.getRequestDispatcher("LibrosAction")
			.include(request, response);
			urlVista="libros.jsp";
			break;
		case "doVenta": 
			request.getRequestDispatcher("VentaAction")
			.include(request, response);
			request.getRequestDispatcher("LibrosAction")
			.include(request, response);
			urlVista="libros.jsp";
			break;
		case "doVaciarCarrito": 
			request.getRequestDispatcher("VaciarCarritoAction")
			.include(request, response);
			request.getRequestDispatcher("LibrosAction")
			.include(request, response);
			urlVista="libros.jsp";
			break;
		
	}
	request.getRequestDispatcher(urlVista)
	.forward(request, response);
	}
}
