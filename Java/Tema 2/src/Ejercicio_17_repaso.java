import java.util.Scanner;

public class Ejercicio_17_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n1 = 0;
		int n2 = 0;
		int n3 = 1;
		int nDeFibonnacci = 0;
		System.out.println("Escribe hasta que numero de fibonnacci quieres saber y te lo imprimire por pantalla.");
		nDeFibonnacci = scanner.nextInt();
		System.out.print("0");
		for (int i = 0; i != (nDeFibonnacci-1); i++) {
				System.out.print(" , "+n3);
				n1 = n2;
				n2 = n3;
				n3 = (n1 + n2);
			
		}

	}

}
