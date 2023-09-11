package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String miUsuario = "Pepe";
		String miPass = "pepe";
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		if (miUsuario.equals(usuario) && miPass.equals(pwd)) {
			// Creo la fecha y la hora
			LocalDateTime ldt = LocalDateTime.now();
			//Creo formato de fecha y hora
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm:ss");
			// Crear variable String fechaActual
			String fechaActual=ldt.format(formater);
			Cookie cookie = new Cookie("fechaultima", fechaActual);
			cookie.setMaxAge(60*60*24*7); //1 semana
			response.addCookie(cookie); // envio el cookie al cliente
			// creamos un objeto de tipo sesión
			HttpSession sesion = request.getSession();
			// creo un atributo
			sesion.setAttribute("usuario", usuario);
			//usuario válido
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("home.html");
			dispatcher.forward(request, response);
			// redireccionamos a página externa
			// response.sendRedirect("http://www.amazon.es?user="+user);
		}else {
			//usuario no válido
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Error");
			 dispatcher.forward(request, response);
		}
	}

}
