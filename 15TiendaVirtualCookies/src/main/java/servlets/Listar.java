package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;


@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String seccion = request.getParameter("seccion");
		seccion=(seccion==null ? "" : seccion);
		List<Producto> productos= (List<Producto>) request.getAttribute("respuesta");
		out.println("<html><body><center>");
		out.println("<h1>Productos encontrados "+seccion+"</h1><br>");
		out.println("<table border=1><tr><td>Nombre</td><td>Sección</td><td>Precio</td><td>Stock</td></tr>");
		productos.forEach(p->out.println("<tr><td>"+p.getNombre()+"</td><td>"
		+p.getSeccion()+"</td><td>"+p.getPrecio()+"</td><td>"+p.getStock()+"</td></tr>"));	
		out.println("</table>");
		out.println("<br><a href='inicio.html'>Menú</a>");
		out.println("</center></body></html>");
	}

}
