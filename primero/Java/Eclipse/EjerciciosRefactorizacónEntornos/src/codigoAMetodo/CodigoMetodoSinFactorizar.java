package codigoAMetodo;

import java.util.Scanner;

public class CodigoMetodoSinFactorizar {

	public static void main(String[] args) {
		/*Sumar numeros introducidos por 
		 * usuario sin factorizar*/
		Scanner sc = new Scanner(System.in);
		Integer suma = 0;
		metodoInutil(sc, suma);
		sc.close();

	}

	private static void metodoInutil(Scanner sc, Integer suma) {
		System.out.println("Dime los números que quieres sumar, se pediran 5");
		for(int i= 0; i>6; i++) {
			suma+=sc.nextInt();
		}
		System.out.println(suma);
	}

}
