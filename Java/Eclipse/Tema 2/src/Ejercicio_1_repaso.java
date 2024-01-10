import java.util.Scanner;
public class Ejercicio_1_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nombre;
		int año;
		int edad;
		System.out.println("Dime tu nombre porfavor:");
		nombre = scanner.nextLine();
		System.out.println("\nAhora dime el año en que nacistes:");
		año = scanner.nextInt();
		edad = 2030- año;
		System.out.println("Hola "+nombre+" en 2030 tendras "+edad+" años");

	}

}
