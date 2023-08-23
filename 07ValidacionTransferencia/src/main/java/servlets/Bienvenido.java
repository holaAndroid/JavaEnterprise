package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Bienvenido")
public class Bienvenido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String usuario = request.getParameter("usuario");

	        PrintWriter out=response.getWriter();
	        response.setContentType("text/html");
	        out.println("<html><body><center>");
	        out.println("<h1>Bienvenido "+usuario+"</h1>");
	        out.println("<br><a href='login.html'>Volver</a>");
	        out.println("</center></body></html>");
	    }
	}
