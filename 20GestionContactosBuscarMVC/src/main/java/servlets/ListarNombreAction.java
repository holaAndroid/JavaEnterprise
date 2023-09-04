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


@WebServlet("/ListarNombreAction")
public class ListarNombreAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Llamamos al metodo de ContactosService
		ContactosService service = new ContactosService();
		//recogo el nombre
		String nombre= request.getParameter("nombre");
		List<Contacto> contactos = service.listaNombre(nombre);
		//forma de pasarse información entre los servlets setAttribute
		request.setAttribute("contactos", contactos);
	}

}
