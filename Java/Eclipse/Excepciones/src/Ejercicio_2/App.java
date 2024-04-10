package Ejercicio_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> lista = new ArrayList<>();
		System.out.println("Dime numeros, pon -1 para parar.");
		Integer numero = 0;
		try {
			do {
				try {
					numero = sc.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("no se pueden poner letras");
				}finally {
					lista.add(numero);
				}
				
			}while(numero != -1);
		}finally {
			sc.close();
		}
		
		for(Integer numeros : lista) {
			System.out.print("\n"+numeros);
		}

	}

}
