package Ejercicio_42;

import java.util.Objects;

public class Jugador {
	private String nombre;
	private Integer dorsal;
	
	public Jugador(String cad, Integer num) {
		this.nombre =cad;
		this.dorsal = num;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDorsal() {
		return dorsal;
	}
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dorsal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(dorsal, other.dorsal);
	}

	public String toString() {
		return this.getDorsal()+"-"+this.getNombre();
	}
	
}
