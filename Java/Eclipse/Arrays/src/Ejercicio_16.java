
import java.util.Scanner;
public class Ejercicio_16 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime una palabra para ponerla del reves");
		String[] palabra = scanner.nextLine().split("");
		
		for (int i = palabra.length-1; i>-1; i--) {
			System.out.print(palabra[i]);
		}
		
	}
}
