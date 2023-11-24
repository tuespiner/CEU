import java.util.Scanner;

public class Ejercicio_19 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime una frase y te dire cuantas a tiene");
		String[] Frase = scanner.nextLine().split("a");
		System.out.print("La frase: ");
		for(int i = 0; i<Frase.length;i++) {
			if (i < Frase.length-1) {
			System.out.print(Frase[i] +"a" );
			}else {
				System.out.print(Frase[i]);
			}
		}
		System.out.print(" tiene "+(Frase.length-1)+" a");

	}

}
