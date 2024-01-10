import java.util.Scanner;

public class Ejercicio_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String num1 = "";
		String num2 = "";
		String num11 = "";
		String num22 = "";
		int comparado = 0;
		System.out.println("Escribe dos textos iguales, dan igual las mayusculas y los espacios, pero si no pone lo mismo lo tendras que repetir");

		do {
			System.out.println("Escribe el texto 1");
			num1 = scanner.nextLine();
			num11 = num1;
			num11 = num11.toLowerCase();
			num11 = num11.replaceAll(" ", "");
			System.out.println("Escribe el texto 2");
			num2 = scanner.nextLine();
			num22 = num2;
			num22 = num22.toLowerCase();
			num22 = num22.replaceAll(" ", "");
			comparado = num11.compareTo(num22);
			if (comparado != 0)  {
				System.out.println("No son iguales los dos textos, repitelo");
			}
		} while (comparado != 0);
		System.out.println("bieeen, el texto 1: " + num1 + " es igual al texto 2: " + num2);

	}

}
