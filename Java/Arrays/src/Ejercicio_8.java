import java.util.Scanner;

public class Ejercicio_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intentos;
		int ram;
		boolean terminar = false;
		System.out.println("Cuantos numeros quieres poner");
		intentos = scanner.nextInt();
		int[] bbdd = new int[intentos];
		for (int i = 0; i < intentos; i++) {
			System.out.println("dime el numero " + (i + 1) + " que quieres poner:");
			bbdd[i] = scanner.nextInt();
		}
		for(int i = 0; i<intentos;i++) {
			System.out.print(bbdd[i]);
		}
		System.out.println("");
		int x = intentos-1;
		for (int i = 0;terminar == false; i++) {
			if (i <= x) {
				ram = bbdd[i];
				bbdd[i] = bbdd[x];
				bbdd[x]=ram;
			}else {
				terminar = true;
			}
			x--;
		}
		for(int i = 0; i<intentos;i++) {
			System.out.print(bbdd[i]);
		}

	}

}
