package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Nombres")
public class Nombres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> nombres = List.of("Antonio", "Maria", "Juan", "Luis", "Ana", "Pedro", "Laura", "Carlos",
			"Sofia", "Diego", "Elena");
	//private String[] letras = { "A", "M", "J", "L", "A", "P", "L", "Ca", "S", "D", "E"};

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pos = request.getParameter("pos").toUpperCase();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<html><body style=\"background-color: black; color: red;text-align: center;\">");
		out.print("<hr><hr><h2>Lista de nombres</h2><hr><hr>");
		nombres.stream()
		.filter(n-> n.startsWith(pos))
		.forEach(n-> out.print("<h2>"+n+"</h2><hr><hr>"));
		out.print("<a href=\"formulario.html\">Volver</a></body></html>");
	}

}
