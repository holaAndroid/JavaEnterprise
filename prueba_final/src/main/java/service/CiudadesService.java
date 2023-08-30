package service;

import java.util.ArrayList;
import java.util.List;

import model.Ciudad;


public class CiudadesService {
	
	static List<Ciudad> ciudades = List.of(new Ciudad("Londres",30),
		   new Ciudad("Paris",40),
		   new Ciudad("Madrid",35),
		   new Ciudad("Las Palmas",25),
		   new Ciudad("Tenerife",35),
		   new Ciudad("Dublín",15)
		   );
	//Dar de alta una ciudad
	public void altaCiudad(Ciudad c) {
		ciudades.add(c);	
	}
	
	//Buscar una ciudad por nombre y devolver un objeto Ciudad
	public Ciudad buscaCiudad(String nombre) { // devuelve una ciudad por eso no puede ser List
		return ciudades.stream()
				//filtro
				.filter(c->c.getNombre().equals(nombre))
				.findAny() // Recojo una ciudad
				.orElse(null); // Sino encuentra ninguna devuelve null
		}
	/*
	//Recibe una ciudad y la elimine de la lista Ciudades
	public void eliminaCiudad(String nombre) {
		ciudades.removeIf(c ->c.getNombre().equals(nombre)); //equalsIgnoreCasa no tiene en cuenta may y min
		
	}*/
	public void eliminaCiudad(Ciudad c) {
		ciudades.remove(c);			
		
	}
	
	//devuelve todas las Ciudades
	// este si devuelve una lista de Ciudades.
	public List<Ciudad> verTodas(){ 
		return ciudades;
	}

}
