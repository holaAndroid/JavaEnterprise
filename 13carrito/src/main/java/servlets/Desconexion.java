package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Desconexion")
public class Desconexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos el objeto sesion
				HttpSession sesion = request.getSession();
				//Nos hecha fuera de la sesión sesion.invalidate
				sesion.invalidate();
				request.getRequestDispatcher("inicio.html")
				.forward(request, response);
	}

}
