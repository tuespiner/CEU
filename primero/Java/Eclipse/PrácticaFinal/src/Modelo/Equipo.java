package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;
	
	public Equipo() {
		this.jugadores = new ArrayList<>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	@Override
	public String toString() {
		Integer i = 1;
		String cad = "EQUIPO: "+this.codigo+" / "+this.nombre+"\n>>> PLANTILLA:\n\t";
		if(this.jugadores != null) {
			for(Jugador j : this.jugadores) {
				cad = cad+"\n\t"+i+j;
			}
		}
		return cad;
	}
	
	
}
