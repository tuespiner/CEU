package Ejercicio_48;

public class Libros extends Articulos{
	private String autor;
	
	public Libros(Double precio, String desc, String  autor) {
		super(precio, desc);
		this.autor = autor;
	}
	
	public Libros() {
		super();
	}
	
	public String getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "Libros [ descripción: "+super.getDescripcion()+", precio: "+super.getPrecio()+
				", autor: "+autor+"]";
	}

	
	
}
