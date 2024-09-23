import java.util.Scanner;
public class Ejercicio_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenidos a nuestro programa \n\nDinos tu nombre porfavor: ");
		String nombreDelUsuario = scanner.nextLine();
		System.out.println("\nPerfecto, dinos tus apellidos ahora porfavor: ");
		String apellidos = scanner.nextLine();
		System.out.println("\nGenial, Su nombre completo es "+nombreDelUsuario+" "+apellidos);
		scanner.close();
	}

}
