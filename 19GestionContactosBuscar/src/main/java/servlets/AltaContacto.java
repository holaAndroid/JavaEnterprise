package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;


@WebServlet("/AltaContacto")
public class AltaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// le damos valor con = request.getParameter("nombre");
		String nombre = request.getParameter("nombre");
		String email  = request.getParameter("email");
		int edad = Integer.parseInt(request.getParameter("edad"));
		Contacto c = new Contacto (0,nombre, email, edad);
		ContactosService service = new ContactosService();
		service.altaContacto(c);
		request.getRequestDispatcher("alta.html")
		.forward(request, response);
	}

}
