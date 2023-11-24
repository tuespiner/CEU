import java.util.Scanner;

public class Ejercicio_19_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		int intro = 0;

		while (x != 3) {
			System.out.println("1- Pasar de pesetas a euros\n2- Pasar de euros a pesetas\n3- Salir");
			x = scanner.nextInt();
			switch (x) {
				case 1:
					System.out.println("dime las pesetas");
					intro = scanner.nextInt();
					System.out.println("\nCon " + intro + " pesetas tienes " + (intro * 0.0060) + " euros\n\n");
					break;
				case 2:
					System.out.println("dime los euros");
					intro = scanner.nextInt();
					System.out.println("\nCon "+ intro + " euros tienes "+(intro*166)+" pesetas\n\n");
					break;
			}
		}

	}

}
