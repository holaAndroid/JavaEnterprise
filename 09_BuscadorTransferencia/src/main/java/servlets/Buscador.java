package servlets;
import model.Pagina;
import service.BuscadorService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tematica = request.getParameter("tematica");
		BuscadorService service = new BuscadorService();
		List<Pagina> paginas= service.buscadorPaginas(tematica);
		RequestDispatcher dispatcher;
		//devuelve una lista sino está vacia.
		if (!paginas.isEmpty()) {
			request.setAttribute("paginas", paginas);
			dispatcher=request.getRequestDispatcher("Listar");	
		}else {
			dispatcher=request.getRequestDispatcher("NoPagina");
		}
		dispatcher.forward(request, response);	
	}

}
