package servlets;

import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Saludo")
public class Saludo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int numero = (int)(Math.random()*1000);
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int numero2 = (int)(Math.random()*1000);
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<html><body>");
        out.print("<h1> Escribiendo una puta mierda y un jodido numero: "+numero+"</h1>");
        out.print("<h2> Escribiendo una puta mierda y un jodido numero: "+numero2+"</h2>");
        out.print("</body></html>");
    }
}
