import java.util.Scanner;

public class Ejercicio_11_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		int num2;
		int opcion;
		boolean salir = false;
		
		System.out.println("CALCULADORA\nDime un numero entero");
		num1 = scanner.nextInt();
		System.out.println("Dime otro nuemro entero");
		num2 = scanner.nextInt();
		
		while (salir != true) {

			System.out.println(
					"\n*** MENU ***\n   1. Sumar\n   2. Restar\n   3. Multiplicar\n   4. Dividir\n   5. Salir");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.println(num1 + num2);
				break;
			case 2:
				System.out.println(num1 - num2);
				break;
			case 3:
				System.out.println(num1 * num2);
				break;
			case 4:
				System.out.println(num1 / num2);
				break;
			case 5:
				System.out.println("saliendo...");
				salir = true;
			}
		}
	}

}
