package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClientesService;

@WebServlet("/ValidarAction")
public class ValidarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String pwd = request.getParameter("pwd");
		
		// Creamos objeto de esa clase
		ClientesService service = new ClientesService();
		boolean valido = service.validar(nombre, pwd);
		request.setAttribute("valido", valido);
	}

}
