import java.util.Scanner;

public class Ejercicio_22 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime una palabra ");
		String[] Frase =  scanner.nextLine().split("");
		for(String output : Frase) {
			System.out.println(output);
		}
	}

}

