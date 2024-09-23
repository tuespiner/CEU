package Estructuras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColaCadenas extends Estructura{
	
	public ColaCadenas() {
		super();
	}
	
	public String sacarCadena() {
		if(datos.size() == 0) {
			return null;
		}else {
			String cad = datos.get(0);
			datos.remove(0);
			return cad;
		}
		
	}
	
}
