package service;
//Control + May + o nos hace todas las importaciones
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductosService {
	
	static List<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentación",8.4,25),
            new Producto("leche","alimentación",1.2,70),
            new Producto("cable usb","informática",5.6,30),
            new Producto("arroz","alimentación",3.1,16),
            new Producto("silla","hogar",30.6,10),
            new Producto("monitor","informática",125.0,5),
            new Producto("escritorio","hogar",230,4)
            ));
	
	//devuelve la lista de productos de la sección
	//que le llegue como parámetro.
	
	public List<Producto> productosSeccion(String seccion){
		return productos.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.toList();
		
	}
	//recibe un producto y lo da de alta
	public void alta(Producto p) {
		productos.add(p);
		
	}
	// recibe el nombre del producto y lo borra
	
	public void eliminar(String nombre) {
		productos.removeIf(p ->p.getNombre().equals(nombre)); //equalsIgnoreCasa no tiene en cuenta may y min
		
		
	}
	
	// recibe nombre y precio y modifica
	
	public void modificar(String nombre, double precio) {
		productos.stream()
		.filter(p->p.getNombre().equals(nombre))
		.forEach(p->p.setPrecio(precio));
	}
	//devuelve todos los productos
	public List<Producto> productosTodos(){
		return productos;
	}

	//devuelve la lista de productos de la sección
		//que le llegue como parámetro.
	public List<Producto> productosNombre(String nombre){
		return productos.stream()
				.filter(p->p.getNombre().equals(nombre))
				.toList();
		
	}
	
}
