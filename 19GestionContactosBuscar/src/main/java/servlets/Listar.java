package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;


@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service = new ContactosService();
		List<Contacto> contactos = service.listaContacto();
		//forma de pasarse información entre los servlets setAttribute
		request.setAttribute("contactos", contactos);
		request.getRequestDispatcher("listado.jsp")
		.forward(request, response);
	}

}
