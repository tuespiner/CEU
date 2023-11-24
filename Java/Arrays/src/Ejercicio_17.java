import java.util.Scanner;
public class Ejercicio_17 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] mayusculas = new String[2];
		
		System.out.println("Dime una frase");
		String[] frase = scanner.nextLine().split(" ");
		
		
		for(int i = 1; i< frase.length;i++) {
			mayusculas[0] = frase[i].substring(0,1);
			mayusculas[1] = frase[i].substring(1,frase[i].length());
			frase[i]= mayusculas[0].toUpperCase()+mayusculas[1];
		}
		for(int i = 0; i<frase.length;i++) {
			System.out.print(frase[i]);
		}
	}
}
