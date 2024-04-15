package prueba;

import java.util.HashSet;
import java.util.Set;

public class Prueba {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		for(String cad : set) {
			System.out.println(cad);
		}

	}
	
	public void prueba(Set<String> set) {
		set.add("Hola");
	}
}
