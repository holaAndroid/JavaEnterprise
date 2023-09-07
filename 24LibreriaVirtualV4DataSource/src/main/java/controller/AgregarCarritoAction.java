package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrito;
import model.Libro;
import service.LibrosService;


@WebServlet("/AgregarCarritoAction")
public class AgregarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Obtenemos ISBN	
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		LibrosService service = new LibrosService();
		Libro libro = service.buscarIsbn(isbn);
		//Creamos el objeto sesion
				HttpSession sesion = request.getSession();
				// Ahora el atributo carrito 
				//para guardar el carrito entero en la sessión
				//Recuperamos ese carrito de la sessión
				List<Libro> carrito = (List<Libro>)sesion.getAttribute("carrito");
				if (carrito==null) {
					//Si no hay carrito, lo creamos
					carrito = new ArrayList<>();
					sesion.setAttribute("carrito", carrito);
					//Lo añadimos a una variable de sesión
				}
				carrito.add(libro);
				//Añadimos el libro a carrito
				
			}

	}

