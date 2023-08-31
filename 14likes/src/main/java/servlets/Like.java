package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Aplicación. Instancia de ServletContent
		ServletContext context = request.getServletContext();
		Integer contador = (Integer)context.getAttribute("contador");
		if (contador==null) {
			contador=0;
		}
		contador++;
		context.setAttribute("contador", contador); // el atributo y el valor
		request.getRequestDispatcher("inicio.html")
		.forward(request, response);
	}

}
