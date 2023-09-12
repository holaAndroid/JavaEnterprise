package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;
import model.Venta;
import service.LibrosService;


@WebServlet("/VaciarCarritoAction")
public class VaciarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sesion = request.getSession();
		List<Libro> carrito =(List<Libro>) sesion.getAttribute("carrito"); //debemos hacer el casting (List<Libro>)
		if (carrito!=null) {
				carrito.removeAll(carrito);
		}
		
	}
}

