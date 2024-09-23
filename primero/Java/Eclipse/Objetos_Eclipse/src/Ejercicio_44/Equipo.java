package Ejercicio_44;

import java.util.ArrayList;
import java.util.List;


public class Equipo {
	private List<Personajes> equipo;
	private Integer totalpv;
	
	public Equipo() {
		this.equipo= new ArrayList<>();
	}
	
	public List<Personajes> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Personajes> equipo) {
		this.equipo = equipo;
	}
	public Integer getTotalPv() {
		return this.totalpv;
	}
	public void añadirPersonaje(Personajes persoAñadir){
		if(equipo.size() == 4) {
			System.out.println("El equipo esta completo");
		}else {
			System.out.println("Has pasado la primera prueba");
			for(Personajes personaje : equipo) {
				if(personaje == persoAñadir) {
					System.out.println("no puedes añadir el mismo personaje");
				}else {
					System.out.println("has pasado la segunda prueba");
					this.equipo.add(persoAñadir);
					this.totalpv = this.totalpv + persoAñadir.getPuntosDeVida();
				}
			}
		}
		
	}

	@Override
	public String toString() {
		return "Equipo [equipo=" + equipo + ", totalpv=" + totalpv + "]";
	}
	
	
	
	
}
