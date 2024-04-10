package Ejercicio_0;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Map<Integer, String> mapa1 = new HashMap<>();
		mapa1.put(1, "Casillas");
		mapa1.put(3, "Piqué");
		mapa1.put(10, "Messi");
		mapa1.put(16, "Busquets");
		mapa1.put(18, "Pedrito");
		mapa1.put(15, "Ramos");
		mapa1.put(5, "Puyol");
		mapa1.put(14, "Xabi Alonso");
		mapa1.put(7, "El Bicho");
		mapa1.put(6, "tu mama");
		
		Set<Integer> claves =  mapa1.keySet();
		for(Integer clave : claves) {
			System.out.println(clave + ", "+mapa1.get(clave));
		}
		
		System.out.println("nº de elementos en el mapa: "+mapa1.size());
		System.out.println("esta vacio?: "+mapa1.isEmpty());
		System.out.println(mapa1.get(6));
		mapa1.remove(18);
		
		System.out.println(mapa1.get(18));
		
		for(Integer clave : claves) {
			System.out.println(clave + ", "+mapa1.get(clave));
		}
		System.out.println(mapa1.containsKey(18));
		System.out.println(mapa1.containsKey(1));
		mapa1.clear();
		System.out.println(mapa1.isEmpty());
		System.out.println(mapa1.size());
	}

}
