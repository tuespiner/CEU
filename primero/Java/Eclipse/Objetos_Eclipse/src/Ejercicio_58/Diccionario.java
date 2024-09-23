package Ejercicio_58;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {
	private Map<String,List<String>> mapa;
	
	public Diccionario() {
		this.mapa = new HashMap<>();
		
	}
	
	public void cargarDiccionario(List<String> lista) {
		String letra = "";
		for(String cad : lista) {
			letra = cad.substring(0,1).toUpperCase();
			if(mapa.containsKey(letra)) {
				mapa.get(letra).add(cad);
			}else {
				mapa.put(letra, new ArrayList<>());
			}
		}
	}
}
