import java.util.Scanner;
public class Ejercicio_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intentos;
		System.out.println("Cuantos numeros quieres poner");
		intentos = scanner.nextInt();
		int[] bbdd = new int[intentos];
		int[] alReves = new int[intentos];
		for(int i= 0; i <intentos; i++) {
			System.out.println("dime el numero "+ (i+1) + " que quieres poner:");
			bbdd[i] = scanner.nextInt();
		}
		int i = 0;
		for(int x = intentos-1; x >-1; x--) {
			alReves[i] = bbdd[x];
			i++;
		}
		for(int x = 0; x < intentos; x++) {
			System.out.print(alReves[x]+ " ");
		}
	}

}
