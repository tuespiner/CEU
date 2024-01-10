import java.util.Scanner;
import java.util.Random;

public class Ejercicio_25_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String respuestaIA = "";
		String respuesta = "";
		int numIA = random.nextInt(0, 4);
		int num = 0;
		boolean terminar = false;
		while (terminar == false) {
			switch (numIA) {
			case 1:
				respuestaIA = "piedra";
				break;
			case 2:
				respuestaIA = "papel";
				break;
			case 3:
				respuestaIA = "tijera";
				break;
			}
			while (num != numIA) {
				System.out.println("elige:\n  1. piedra\n  2. papel\n  3. tijeras");
				num = scanner.nextInt();
				switch (num) {
				case 1:
					respuesta = "piedra";
					break;
				case 2:
					respuesta = "papel";
					break;
				case 3:
					respuesta = "tijera";
					break;
				}
				if ((num == 1 ) && (numIA == 1)) {
					System.out.println("");
				}
			}

		}
	}

}
