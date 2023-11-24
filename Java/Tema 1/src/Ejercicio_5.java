import java.util.Scanner;
public class Ejercicio_5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("¿Cuánto te gustaria ganar al año?");
		int anual = scanner.nextInt();
		int mensual = anual / 12;
		System.out.println("\nTu sueldo mensual seria de "+mensual+" euros.");
		scanner.close();
	}

}
