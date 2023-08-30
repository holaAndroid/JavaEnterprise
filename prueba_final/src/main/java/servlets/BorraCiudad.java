package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ciudad;
import service.CiudadesService;



@WebServlet("/BorraCiudad")
public class BorraCiudad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String nombre = request.getParameter("nombre"); este no necesario
		CiudadesService service = new CiudadesService();
		//opción A
		//service.eliminaCiudad(request.getParameter(nombre));
		//Opción B
		Ciudad ciudad= service.buscaCiudad("nombre");
		if (ciudad!=null) {
			service.eliminaCiudad(ciudad);
		}
		response.sendRedirect("home.html");
	}

}
