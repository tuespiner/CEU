package Ejercicio_47;

public class Articulos {
	private Double precio;
	private String descripcion;
	
	public Articulos(Double precio, String desc) {
		this.precio = precio;
		this.descripcion = desc;
	}
	
	public Articulos() {
		
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	
}
