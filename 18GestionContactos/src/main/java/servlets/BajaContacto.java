package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;


@WebServlet("/BajaContacto")
public class BajaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		ContactosService service = new ContactosService();
		if (!service.bajaContacto(nombre)) {
			request.getRequestDispatcher("baja.html")
			.forward(request, response);
		}else {
			request.getRequestDispatcher("home.html")
			.forward(request, response);
		}
	}

}
