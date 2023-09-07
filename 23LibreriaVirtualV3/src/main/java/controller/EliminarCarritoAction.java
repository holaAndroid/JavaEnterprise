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

import model.Libro;
import service.LibrosService;

@WebServlet("/EliminarCarritoAction")
public class EliminarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo la posición del libro en el carrito.
		int position = Integer.parseInt(request.getParameter("position"));
		//Creamos el objeto sesion
				HttpSession sesion = request.getSession();
				// Ahora el atributo carrito 
				//para guardar el carrito entero en la sessión
				//Recuperamos ese carrito de la sessión
				List<Libro> carrito = (List<Libro>)sesion.getAttribute("carrito");
				if (carrito!=null) {
					//Si  existe carrito elimino el libro
					carrito.remove(position);
				}		
		}
	
	}


