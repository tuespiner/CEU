package Estructuras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Estructura {
	protected List<String> datos;
	
	public Estructura() {
		this.datos = new ArrayList<>();
	}
	
	public void añadirCadena(String cad) {
		this.datos.add(cad);
	}
	
	public Integer getTamaño() {
		return this.datos.size();
	}
	
	public String toString() {
		return datos.toString();
	}
	
	public abstract String sacarCadena();
}
