package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import service.ProductosService;

@WebServlet("/Alta")

public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String seccion = request.getParameter("seccion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		Producto p = new Producto(nombre,seccion,precio,stock);
		ProductosService service = new ProductosService();
		service.alta(p);
		/*
		RequestDispatcher dispatcher;
		dispatcher=request.getRequestDispatcher("alta.html");	
		dispatcher.forward(request, response);	
		*/
		//request.getRequestDispatcher("alta.html").forward(request, response);
		//segunda opción
		response.sendRedirect("alta.html");
	}
}

