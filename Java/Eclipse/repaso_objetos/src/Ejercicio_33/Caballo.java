package Ejercicio_33;

public class Caballo {
	private String nombre;
	private String color;
	private int edad;
	private int carrerasGanadas;
	
	public void imprimeCarrerasGanada() {
		System.out.println("El numero de carreras ganas es: " + this.carrerasGanadas);
	}
	
	public Integer añoNacimineto() {
		Integer añoActual = 2024;
		return añoActual - edad;
		
	}
	
	public void incrementarCarrerasGanadas() {
		this.carrerasGanadas++;
		
	}
	
	public void relincha() {
		System.out.println("IEIEIIEIE");
	}

	public int getCarrerasGanadas() {
		return carrerasGanadas;
	}
	
	

	public Caballo(String nombre, String color, int edad, int carrerasGanadas) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.edad = edad;
		this.carrerasGanadas = carrerasGanadas;
	}
	
	public Caballo() {
		this.nombre = "";
		this.color = "";
		this.edad = 0;
		this.carrerasGanadas = 0;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Caballo [nombre=" + nombre + ", edad=" + edad + ", color="+color+ ", carrerasGanadas=" + carrerasGanadas + "]";
	}
	
	//GETTERS AND SETTERS
	public void setCarrerasGanadas(int carrerasGanadas) {
		this.carrerasGanadas = carrerasGanadas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
