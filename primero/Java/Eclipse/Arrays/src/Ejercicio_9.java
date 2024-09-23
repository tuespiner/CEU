import java.util.Scanner;

public class Ejercicio_9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intentos;
		boolean terminar = false;
		int x = 0;
		System.out.println("Cuantos numeros quieres poner");
		intentos = scanner.nextInt();
		Integer[] masGrande = new Integer[(intentos + 3)];
		Integer[] bbdd = new Integer[intentos];
		for (int i = 0; i < intentos; i++) {
			System.out.println("dime el numero " + (i + 1) + " que quieres poner:");
			bbdd[i] = scanner.nextInt();
		}
		do {
			for (int i = 0; i < intentos; i++) {
				if (bbdd[i] != null) {
					masGrande[0] = bbdd[i];
					if (masGrande[1]==null||masGrande[0] > masGrande[1]) {
						masGrande[1] = masGrande[0];
						masGrande[2] = i;
					}
				}
			}
			masGrande[x + 3] = masGrande[1];
			masGrande[1] = null;
			bbdd[masGrande[2]] = null;
			x++;
		} while (x < intentos);

		for (int i = 0; i < intentos; i++) {
			System.out.print(masGrande[(i + 3)] + " ");
		}

	}

}
