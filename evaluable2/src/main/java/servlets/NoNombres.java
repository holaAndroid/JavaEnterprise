package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NoNombres")
public class NoNombres extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static List<String> nombres = List.of("Ana", "Alberto", "Elena", "Martin", "Carlos", "Lucas");


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        int longitud = Integer.parseInt(request.getParameter("numero"));
        out.println("<html><body>");
        out.println("No hay datos de longitud "+longitud);
        out.println("</body></html>");
	}

}
//http://localhost:8080/evaluable2/NoNombres?numero=8
