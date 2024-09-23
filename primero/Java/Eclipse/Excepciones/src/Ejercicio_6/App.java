package Ejercicio_6;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Persona persona = new Persona();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vamos a crear una persona, dimie el genero");
		do {
			try {
				persona.setGenero(sc.nextLine());
			}catch(ParametroIntroducidoIncorrectoException e) {
				System.out.println(e.getMessage());
			}
		}while(persona.getGenero() == null);
		
		System.out.println("Perfecto ahora dime la altura");
		do {
			try {
				persona.setAltura(sc.nextBigDecimal());
			}catch(ParametroIntroducidoIncorrectoException i) {
				System.out.println(i.getMessage());
			}
		}while(persona.getAltura() == null);
		
		
		System.out.println("Perfecto, tu persona es " + persona.getGenero()+ " y mide "+persona.getAltura()+" metros.");
		sc.close();
	}

}
