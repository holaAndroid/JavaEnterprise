package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClientesService;


@WebServlet("/RegistrarAction")
public class RegistrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente c = new Cliente (
				0,request.getParameter("nombre"), 
				request.getParameter("pwd"), 
				request.getParameter("email"),
				request.getParameter("telefono"));
		ClientesService service = new ClientesService();
		service.registrar(c);
		
	}

}
