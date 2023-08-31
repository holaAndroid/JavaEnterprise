package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class Carrito {
	//Creamos lista vacia de productos
	private List<Producto> productos = new ArrayList<>();
	
	//devuelve todos los productos de carrito
	public List<Producto> getProductos(){
		return productos;
	}
	// verificar si se agrego el producto
	public boolean agregar(Producto producto) {
		return productos.add(producto);
	}
	


}
