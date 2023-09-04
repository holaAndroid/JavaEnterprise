package servlets;

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
	String urlVista = "home.html";
	switch (option) {
		case "doAlta":
			request.getRequestDispatcher("AltaAction")
			.include(request, response);
			urlVista="home.html";
			break;
		case "doBaja":
			request.getRequestDispatcher("BajaAction")
			.include(request, response);
			urlVista="home.html";
			break;
		case "doBajaEmail":
			request.getRequestDispatcher("BajaEmailAction")
			.include(request, response);
			urlVista="home.html";
			break;
		case "doListar":
			request.getRequestDispatcher("ListarAction")
			.include(request, response);
			urlVista="listado.jsp";
			break;
		case "doNombre":
			request.getRequestDispatcher("ListarNombreAction")
			.include(request, response);
			urlVista="listado.jsp";
			break;
		case "toMenu":
			urlVista="home.html";
			break;
		case "toAlta":
			urlVista="alta.html";
			break;
		case "toBaja":
			urlVista="baja.html";
			break;
		case "toBajaEmail":
			urlVista="bajaemail.html";
			break;
		case "toNombre":
			urlVista="nombre.html";
			break;
	}
	request.getRequestDispatcher(urlVista)
	.forward(request, response);
	}
}