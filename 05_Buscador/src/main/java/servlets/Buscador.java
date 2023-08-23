package servlets;
import model.Pagina;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Pagina> paginas=List.of(
            new Pagina("http://www.casadellibro.es/", "libros","Libros y más cosas"),
            new Pagina("http://www.gamers.es/", "juegos","Todo sobre video juegos"),
            new Pagina("http://www.pccomponentes.com/", "informática","Componentes de ordenador"),
            new Pagina("http://www.fnac.es/", "libros","Bienvenido al mundo del ocio y la cultura"),
            new Pagina("http://www.books.es/", "libros","Entra en el mundo del libro"),
            new Pagina("http://www.xataca.com/", "informática","Tecnología e Informática"));
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tematica = request.getParameter("tematica");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		 //out.print("<html><body style=\"background-color: black; color: red;text-align: center;\">");
		out.print("<h3>Listado de paginas de tematica: "+tematica+"</h3>");
		out.print("");
		paginas.stream().filter(n-> n.getTematica().equals(tematica)).forEach
		(n->out.print("<h4><a href='"+n.getDireccion()+"'>"+n.getDireccion()+"</a><br>"+
		n.getDescripcion()+"</h4>"));
		out.print("<h3><a href=\'formulario.html\'>Volver</a></h3>");
		out.print("</body></html>");
		
	}

}
