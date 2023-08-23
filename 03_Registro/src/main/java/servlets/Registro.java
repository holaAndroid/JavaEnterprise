package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//datos del formulario
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String sexo = request.getParameter("sexo");;
		String[] preferencias= request.getParameterValues("prefs");
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        out.print("<html><body style=\"background-color: black; color: red;text-align: center;\">");
        out.print("Saludos "+sexo+" "+nombre+".<br>");
		out.print("Su edad es: "+edad+".<br>");
		out.print("Su email es: "+email+".<br>");
		out.print("Sus preferencias son: ");
		Arrays.stream(preferencias!=null ? preferencias :new String [] {"Sin preferencias"}).forEach(n-> out.print(n+"º "));
        out.print("</body></html>");
	}

}
