package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Colorea")
public class Colorea extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Colorea() {
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String color = request.getParameter("color");
				
				PrintWriter out=response.getWriter();
		        response.setContentType("text/html");
		        out.println("<html><body bgcolor='"+color+"'>");
		        out.println("<a href='datos.html'>Volver</a>");
		        out.println("</body></html>");
	}

}
