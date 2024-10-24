package tuCuloGordo;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Boolean buleano = false;
		while(buleano == false) {
			System.out.println("Dime tu edad");
			int edad = sc.nextInt();
			if (edad >= 18) {
				System.out.println("Mayor de edad");
				if (edad == 100) {
					System.out.println("Salgo del bucle");
					buleano = true;
				}
			}else if (edad <= 0){
				System.out.println("No has nacido");
				
			}
			else {
				System.out.println("Menor de edad");
			}

		}
		
	}

}
