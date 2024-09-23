package Ejercicio_22;

public class Persona {
	private String nombre;
	private Integer edad;

	//CONSTRUCTOR
	public Persona(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona() {
		this.nombre = "";
		this.edad = 0;
	}

	// SETTERS AND GETTERS
		// NOMBRE
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		// EDAD
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
