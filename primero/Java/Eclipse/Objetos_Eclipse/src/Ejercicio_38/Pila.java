package Ejercicio_38;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pila {
	private List<String> pilaCadena;
	
	public Pila() {
		this.pilaCadena= new ArrayList<>();
	}
	
	public void añadirCadena(String cad) {
		this.pilaCadena.add(cad);
	}
	
	public String sacarCadena() {
		if(pilaCadena.size()== 0 && pilaCadena.get(0) == null) {
			return "cadena vacia";
		}else {
			String cad = this.pilaCadena.get(pilaCadena.size()-1);
			this.pilaCadena.remove(pilaCadena.size()-1);
			return cad;
		}
		
	}
	
	public Integer getTamaño() {
		return this.pilaCadena.size();
	}
	
	public String toString() {
		Iterator<String> it = pilaCadena.iterator();
		String cad = "[ ";
		while(it.hasNext()) {
			if(cad.equals("[ ")) {
				cad = cad + it.next();
			}else {
				cad = cad + ", " + it.next();
			}
		}
		return cad = cad + " ]";
	}
	
	
}
