package Ejercicio_48;

public class Ropa extends Articulos{
	private String talla;
	private String color;
	
	public Ropa(Double precio, String desc, String talla, String color) {
		super(precio, desc);
		this.talla = talla;
		this.color = color;
	}
	
	public Ropa() {
		super();
	}
	
	public String getTalla() {
		return talla;
	}
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Ropa [Descripcion: "+super.getDescripcion()+", precio: "+super.getPrecio()+", talla: "
				+talla+", color: "+color+"]";
	}

	
	
	
	
}
