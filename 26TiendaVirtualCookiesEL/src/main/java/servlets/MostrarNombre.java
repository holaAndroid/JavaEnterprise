package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import service.ProductosService;


@WebServlet("/MostrarNombre")
public class MostrarNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		ProductosService service = new ProductosService();
		List<Producto> respuesta = service.productosNombre(nombre);
		RequestDispatcher dispatcher;
		if (!respuesta.isEmpty()) {
			request.setAttribute("respuesta", respuesta);
			dispatcher=request.getRequestDispatcher("listar.jsp");
		}else{
			dispatcher=request.getRequestDispatcher("noencontrado.jsp");	
		}	
		dispatcher.forward(request, response);
	}

}
