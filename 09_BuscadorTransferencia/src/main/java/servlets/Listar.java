package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;

@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String tematica = request.getParameter("tematica");
		List<Pagina> paginas= (List<Pagina>) request.getAttribute("paginas");
		out.println("<html><body><center>");
		out.println("<h1>Paginas encontradas de "+tematica+"</h1><br>");
		paginas.forEach(p->out.println("<a href='"+p.getDireccion()
			+"'>"+p.getDireccion()+"</a><br>"+p.getDescripcion()
			+"<br><br>"));
		out.println("<a href='formulario.html'>Volver</a>");
		out.println("</center></body></html>");
	}

}
