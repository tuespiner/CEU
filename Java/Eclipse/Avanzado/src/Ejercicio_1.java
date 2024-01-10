import java.util.Scanner;

public class Ejercicio_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String frase = "";
		String parte = "";
		String solucion = "";
		String mayus = "";
		int espacio1 = 0;
		int espacio2 = 0;
		int longitudParte = 0;
		boolean terminar = false;

		System.out.println("Dime una frase, la que sea");
		frase = ((scanner.nextLine()).toLowerCase()).trim();
		frase = frase + " ";
		espacio1 = frase.indexOf(" ");
		solucion = frase.substring(0, espacio1);
		while (terminar != true) {
			espacio1 = frase.indexOf(" ", (espacio1 + longitudParte));
			espacio2 = frase.indexOf(" ", (espacio1 + 1));
			if (espacio2 != -1) {
				parte = frase.substring((espacio1 + 2), espacio2);
				mayus = frase.substring(espacio1+1, (espacio1 + 2));
				solucion = solucion + (mayus.toUpperCase()) + parte;
				longitudParte = parte.length();
			} else {
				terminar = true;
			}
		}
		System.out.println(solucion);

	}
}
