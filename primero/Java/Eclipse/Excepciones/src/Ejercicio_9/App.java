package Ejercicio_9;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sociedad sociedad = new Sociedad();
		int eleccion = 0;
		int contador = 0;
		String genero = "";
		BigDecimal altura = BigDecimal.ZERO;

		
		while (true) {
			System.out.println("Seleccione 1:\n\t1: Introducir persona\n\t2: Terminar");
			eleccion = sc.nextInt();sc.nextLine();
			if(eleccion == 1) {
				contador = 0;
				do {
					System.out.println("Dime el genero de la persona");
					genero = sc.nextLine();
					System.out.println("Dime la altura de la persona");
					altura = sc.nextBigDecimal();
					sc.nextLine();
					try {
						sociedad.addPersona(genero, altura);
						contador = 1;
					} catch (ParametroIntroducidoIncorrectoException e) {
						System.err.println(e.getMessage());
					}
				} while (contador == 0);
			}else {
				break;
			}
		}
		try {
			System.out.println("Hombre: "+sociedad.calcularAlturaMediaHombres());
			
			System.out.println("Mujer: "+sociedad.calcularAlturaMediaMujeres());
			
			System.out.println("Todos: "+sociedad.calcularAlturaMedia());
		}catch(ParametroIntroducidoIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			sociedad.borrarGenero("H");
		}catch(ParametroIntroducidoIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(sociedad);

	}
}
