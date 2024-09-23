package Estructuras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pila extends Estructura{
	
	public Pila() {
		super();
	}
	
	public String sacarCadena() {
		if(datos.size()== 0 && datos.get(0) == null) {
			return "cadena vacia";
		}else {
			String cad = this.datos.get(datos.size()-1);
			this.datos.remove(datos.size()-1);
			return cad;
		}
		
	}
	
	
	
	
}
