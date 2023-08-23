package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String miUsuario = "Pepe";
		String miPass = "pepe";
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		if (miUsuario.equals(usuario) && miPass.equals(pwd)) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Bienvenido");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("NoEncontrado");
			 dispatcher.forward(request, response);
		}
	}

}
