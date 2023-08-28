package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Nombres")
public class Nombres extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static List<String> nombres = List.of("Ana", "Alberto", "Elena", "Martin", "Carlos", "Lucas");
    protected void service(HttpServletRequest request, HttpServletResponse 
            response) throws ServletException, IOException {
// Apartado 1
    	/*
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        /* 
         * List<String> longitudNombres = 
         * 				nombres.stream()
         * 				.filter(nombre -> nombre.length()>5)
         * 				.collect(Collector.toList())
         * 					*/      
    	/* List<String> lista = 
        		nombres.stream()
        		.filter(n->n.length()>5) // Filtro
        		.toList(); // Convierte en lista
        out.println("<html><body>");
        lista.forEach(n->out.println(n));
        out.println("</body></html>");
        */
        //Apartado 2
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        int longitud = Integer.parseInt(request.getParameter("numero"));
         List<String> lista = 
        		nombres.stream()
        		.filter(n->n.length()==longitud ) // Filtro
        		.toList(); // Convierte en lista
        out.println("<html><body>");
        lista.forEach(n->out.println(n));
        out.println("</body></html>");
    }
}
//http://localhost:8080/evaluable2/NoNombres?numero=6
//http://localhost:8080/evaluable2/NoNombres?numero=3
