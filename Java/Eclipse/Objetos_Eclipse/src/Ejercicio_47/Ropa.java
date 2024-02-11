package Ejercicio_47;

public class Ropa extends Articulos{
	private Integer talla;
	private String color;
	
	public Ropa(Double precio, String desc, Integer talla, String color) {
		super(precio, desc);
		this.talla = talla;
		this.color = color;
	}
	
	public Ropa() {
		super();
	}
	
	public Integer getTalla() {
		return talla;
	}
	public String getColor() {
		return color;
	}
	
	
}
