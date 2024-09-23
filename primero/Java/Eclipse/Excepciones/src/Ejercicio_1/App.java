package Ejercicio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> lista = new ArrayList<>();
		System.out.println("Dime numeros, pon -1 para parar.");
		try {
			do {
				lista.add(sc.nextInt());
			}while(lista.get(lista.size()-1) != -1);
		}finally {
			sc.close();
		}
		
		for(Integer numeros : lista) {
			System.out.print("\n"+numeros);
		}

	}

}
