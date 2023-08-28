package service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NombresService")
public class NombresService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> nombres = List.of("Ana", "Alberto", "Elena", "Martin", "Carlos", "Lucas");
//	Devuélveme una lista con los nombres que empiecen por “A” ordenados alfabéticamente.
		 			nombres.stream()
	                .filter(nombre -> nombre.startsWith("A")) // Filtro
	                .sorted() // ordenados
	                .toList(); //Convierto en lista
//	Imprime los nombres cuya longitud sea igual a 5.
		 			nombres.stream()
		 			.filter(n -> n.length() == 5) // Filtro
		 			.forEach(n->System.out.println(n));

//	Imprime la longitud de los nombres de la lista ordenada de forma 
//ascendente.
		 		 nombres.stream()
				 .mapToInt(n -> n.length()) // Crea un nuevo strem de enteros
				 .sorted() //Ordenados
				 .forEach(n->System.out.println(n)); // Imprime

//	Devuélveme la suma de las longitudes de todos los nombres.
		 		 		nombres.stream()
		 				.mapToInt(n -> n.length()) //Crea un nuevo stream de enteros
		                .sum(); // Devuelve la suma

	}

}
