import java.util.Scanner;
public class Ejercicio_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Dime tu edad porfavor");
		int edad = scanner.nextInt();
		System.out.println("\nSu edad es de "+edad+" años");
		scanner.close();

	}

}
