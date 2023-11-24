
import java.util.Scanner;

public class Ejercicio_12_repaso {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int contador3 = 1;
		int contador = 1;

		System.out.println("dime un número mayor de cero para hacerte una cuadricula. ( Ejem: N x N ).");

		int numTablero = scanner.nextInt();
		System.out.print(" ");
		for (int contador2 = 1; contador2 <= numTablero; contador2++) {
			for (; contador3 <= (numTablero + (numTablero - 1)); contador3++) {
				System.out.print("_");
				if (contador3 == (numTablero + (numTablero - 1))) {
					System.out.println("");
				}
			}
			for (contador = 1; contador <= numTablero; contador++) {
				System.out.print("|_");
			}
			System.out.print("|");
			System.out.println("");
		}

	}

}