package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ciudad;
import service.CiudadesService;


@WebServlet("/AltaCiudad")
public class AltaCiudad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ciudad c=new Ciudad(request.getParameter("nombre"),
			Integer.parseInt(request.getParameter("temperatura")));
		CiudadesService service = new CiudadesService();
		service.altaCiudad(c);
		
		/*String nombre = request.getParameter("nombre");
		double temperatura = Double.parseDouble(request.getParameter("temperatura"));
		Ciudad c = new Ciudad(nombre,temperatura);
		CiudadesService service = new CiudadesService();
		service.altaCiudad(c);*/
		response.sendRedirect("menu.html");
	}

}
