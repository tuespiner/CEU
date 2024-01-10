import java.util.Scanner;
import java.util.Random;

public class Ejercicio_23_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int nºDeVeces;
		int numero;
		System.out.println("dinos cuantas veces quieres que lancemos el dado");
		nºDeVeces = scanner.nextInt();
		for(int i = 0; i != nºDeVeces; i++) {
			switch(nºDeVeces) {
			case 1:
				numero = random.nextInt(1,7);
				System.out.println(numero);
				numero = 0;
				break;
			case 2:
				numero = random.nextInt(1,7);
				System.out.println(numero);
				numero = 0;
				break;
			case 3:
				numero = random.nextInt(1,7);
				System.out.println(numero);
				numero = 0;
				break;
			case 4:
				numero = random.nextInt(1,7);
				System.out.println(numero);
				numero = 0;
				break;
			case 5:
				numero = random.nextInt(1,7);
				System.out.println(numero);
				numero = 0;
				break;
			case 6:
				numero = random.nextInt(1,7);
				System.out.println(numero);
				numero = 0;
				break;
			}
		}
	}
}
