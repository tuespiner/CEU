import java.util.Scanner;

public class Ejercicio_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1 = 0;
		double num2 = 0;
		System.out.println("Escribe dos numeros iguales, si no son iguales te pediremos que los escribas de nuevo");

		do {
			System.out.println("Escribe el numero1");
			num1 = scanner.nextDouble();
			System.out.println("Escribe el numero2");
			num2 = scanner.nextDouble();
			if (num1 != num2) {
				System.out.println("No son iguales los dos numeros, repitelo");
			}
		} while (num1 != num2);
		System.out.println("bieeen, el numero 1 " + num1 + " es igual al numero 2 " + num2);

	}

}
