package service;

import java.util.List;

import model.Pagina;

public class BuscadorService {

	List<Pagina> paginas=List.of(
		      new Pagina("http://www.casadellibro.es/", "libros","Libros y más cosas"),
		      new Pagina("http://www.gamers.es/", "juegos","Todo sobre video juegos"),
		      new Pagina("http://www.pccomponentes.com/", "informática","Componentes de ordenador"),
		      new Pagina("http://www.fnac.es/", "libros","Bienvenido al mundo del ocio y la cultura"),
		      new Pagina("http://www.books.es/", "libros","Entra en el mundo del libro"),
		      new Pagina("http://www.xataca.com/", "informática","Tecnología e Informática"));
	public List<Pagina> buscadorPaginas(String tema){
		return paginas.stream()
				.filter(n->n.getTematica()
				.equals(tema))
				.toList();

	}
}
