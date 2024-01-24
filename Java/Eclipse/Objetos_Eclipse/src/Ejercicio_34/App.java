package Ejercicio_34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> lista= new ArrayList();
		
		for(int i = 0; i<5; i++) {
			lista.add(sc.nextLine());
		}
		System.out.println(lista.toString());
		if(lista.contains("") == true) {
			System.out.println("Contiene una cadena vacia");
		}else {
			System.out.println("No contine cadenas vacias");
		}

	}

}
 