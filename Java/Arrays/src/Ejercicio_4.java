import java.util.Scanner;
public class Ejercicio_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intentos;
		System.out.println("Cuantos numeros quieres poner");
		intentos = scanner.nextInt();
		int[] bbdd = new int[intentos];
		for(int i= 0; i <intentos; i++) {
			System.out.println("dime el numero "+ (i+1) + " que quieres poner:");
			bbdd[i] = scanner.nextInt();
		}
		for(int x = intentos-1; x >-1; x--) {
			System.out.print(bbdd[x]+ " ");
		}
		for(int x = 0; x < intentos; x++) {
			System.out.print(bbdd[x]+ " ");
		}
		scanner.close();
	}

}
