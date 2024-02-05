package Ejercicio_44;

public class Jugador {
	private String nombre;
	private Equipo equipo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", equipo=" + equipo + "]";
	}
	
	
	
}
