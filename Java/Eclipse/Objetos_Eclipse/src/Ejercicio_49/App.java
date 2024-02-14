package Ejercicio_49;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Set<String> conjunto1 = new HashSet<>();
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Dime 5 cadenas para meterlas en un conjunto");
		
		for(int i = 0; i <=4; i++) {
			conjunto1.add(sc.nextLine());
		}
		
		Set<String> conjuntoMayus = new HashSet<>();
		for(String cad : conjunto1) {
			conjuntoMayus.add(cad.toUpperCase());
		}
		
		System.out.println(conjuntoMayus);
		
		for(String cad : conjuntoMayus) {
			if(cad.trim().equals("")) {
				System.out.println("Hay cadenas vacias");
			}
		}
		
		Iterator<String> iterador = conjuntoMayus.iterator();
		
		while(iterador.hasNext()) {
			if (iterador.next().length()<6) {
				iterador.remove();
			}
		}
		
		System.out.println(conjuntoMayus);
		
		

	}

}
