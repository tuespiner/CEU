package Ejercicio_34;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> lista= new ArrayList();
		
		
		System.out.println("Mete ");
		for(int i = 0; i<5; i++) {
			lista.add(sc.nextLine());
		}
		System.out.println(lista.toString());
		
		for(int i = 0; i<lista.size(); i++) {
			lista.set(i, lista.get(i).toUpperCase());
		}
		System.out.println(lista.toString());
		
		if(lista.contains("") == true) {
			System.out.println("Contiene una cadena vacia");
		}else {
			System.out.println("No contine cadenas vacias");
		}
		Iterator < String > it = lista.iterator();
		while(it.hasNext()) {
			if(it.next().length()<6) {
				it.remove();
			}
			
		}
		System.out.println(lista);

	}

}
 