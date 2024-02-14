package Ejercicio_50;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Set<Pais> paises = new HashSet<>();
		
		System.out.println(paises);
		
		Pais pais1 = new Pais("ES","España");
		Pais pais2 = new Pais("CK","Islas Cook");
		Pais pais3 = new Pais("CK","Isas Caimán");
		
		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		
		System.out.println(paises);
		
		Pais pais4 = new Pais("es","España");
		
		paises.add(pais4);
		
		System.out.println(paises);
		
		Iterator<Pais> it = paises.iterator();
		
		while(it.hasNext()) {
			if(!it.next().equals(pais1)) {
				it.remove();
			}
		}
		
		System.out.println(paises);
		
		paises.clear();
	}

}
