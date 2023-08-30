package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ciudad;
import service.CiudadesService;




@WebServlet("/MostrarTodas")
public class MostrarTodas extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       response.setContentType("text/html");
	       PrintWriter out = response.getWriter();
	        CiudadesService service = new CiudadesService();
			List<Ciudad> ciudades= service.verTodas();
			out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Mostrar todas las ciudades</title>");
	        out.println("</head>");
	        out.println("<body>");
	
	        for (Ciudad ciudad : ciudades) {
	            out.println("<p>" + ciudad.getNombre() + ", " + ciudad.getTemperatura() + "</p>");
	        }
	
	        out.println("</body>");
	        out.println("</html>");
    }
}
