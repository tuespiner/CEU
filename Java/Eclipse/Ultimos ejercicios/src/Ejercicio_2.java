import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int altura = 0;
		String espacio = "  ";
		String estrella = "* ";
		System.out.println("dime al altura del triangulo");
		altura = scanner.nextInt();
		int posiEspacio1 = 0;
		for (int i = 0; i < (altura * 2); i++) {
			if (i < altura) {
				for (int x = 0; x <= (altura) - 1; x++) {
					if ((posiEspacio1 <= x)) {
						System.out.print(espacio);
					} else {
						System.out.print(estrella);
					}
				}
				posiEspacio1++;
			}else {
				for (int x = 0; x <= (altura) - 1; x++) {
					if ((posiEspacio1 <= x)) {
						System.out.print(espacio);
					} else {
						System.out.print(estrella);
					}
				}
				posiEspacio1--;
			}
			System.out.println("");
		}

	}

}
