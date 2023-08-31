package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;
import service.Carrito;


@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el parametro
		String nombre = request.getParameter("nombre");
		//Creamos el objeto sesion
		HttpSession sesion = request.getSession();
		// Ahora el atributo carrito 
		//para guardar el carrito entero en la sessión
		//Recuperamos ese carrito de la sessión
		Carrito carrito = (Carrito)sesion.getAttribute("carrito");
		if (carrito==null) {
			carrito = new Carrito();
			sesion.setAttribute("carrito", carrito);
		}
		carrito.agregar(new Producto(nombre));
		request.getRequestDispatcher("inicio.html")
		.forward(request, response);
		
	}

}
