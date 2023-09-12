package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosService;


@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogemos el idTema que me envía el formulario
		int idTema=Integer.parseInt(request.getParameter("idTema"));
		LibrosService service = new LibrosService();
		List<Libro> libros = (idTema == 0)
				? service.obtenerLibros()
				: service.obtenerLibros(idTema);
		request.setAttribute("libros", libros);
	}

}
