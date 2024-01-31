package Ejercicio_42;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private String nombre;
	private Jugador capitan;
	private List<Jugador> jugadores;
	private String competicion;
	
	public Equipo(String cad) {
		this.nombre = cad;
		this.jugadores = new ArrayList<>();
	}
	
	
	public String getCompeticion() {
		return competicion;
	}



	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}



	public Jugador getCapitan() {
		return capitan;
	}
	public void setCapitan(Jugador capitan) {
		this.capitan = capitan;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setJugadores(Jugador jugador){
		jugadores.add(jugador);
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public String toString() {
		String cad = this.getNombre()+"-Capitán:"+this.getCapitan()+"-Jugadores:"+"[";
		for(Jugador jugador : jugadores) {
			cad = cad+jugador+", ";
		}
		cad = cad + "]";
		return cad;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}
}
