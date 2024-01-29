package Ejercicio_37;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColaCadenas {
	private List<String> listaCadenas;
	
	public ColaCadenas() {
		this.listaCadenas = new ArrayList<>();
	}
	
	public void añadirCadena(String cad) {
		this.listaCadenas.add(cad);
	}
	
	public String sacarCadena() {
		if(this.listaCadenas.size() == 0) {
			return null;
		}else {
			String cad = this.listaCadenas.get(0);
			this.listaCadenas.remove(0);
			return cad;
		}
		
	}
	
	public int getTamaño() {
		return this.listaCadenas.size();
	}
	
	public String toString() {
		Iterator<String> it = listaCadenas.iterator();
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
