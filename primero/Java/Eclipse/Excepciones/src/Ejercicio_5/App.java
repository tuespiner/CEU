package Ejercicio_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		SacoNumeros numeros = new SacoNumeros();
		Scanner sc = new Scanner(System.in);
		Integer intro = 0;
		System.out.println("Dime numeros enteros, pon -1 para parar");
		do {
			try {
				intro = sc.nextInt();
				if(intro != -1) {
					numeros.addNumero(intro);
				}
				
			} catch(InputMismatchException e) {
				System.out.println("No se pueden insertar letras, caracteres especiales"
						+ " o numeros con decimales, solo numeros enteros");
				sc.nextLine();
			}
			
		}while(intro != -1);
		
		System.out.println(numeros);
		
		System.out.println(numeros.division());
	}

}
