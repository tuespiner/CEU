import java.util.Scanner;
public class Ejercicio_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenidos a nuestro programa \n\nDinos tu nombre porfavor: ");
		String nombreDelUsuario = scanner.nextLine();
		System.out.println("\nBienvenido "+nombreDelUsuario+"\n\n¿De dónde eres?");
		String ubicación = scanner.nextLine();
		System.out.println("\n¿Qué tal se vive en "+ubicación+"?");
		String respuestaUltimaPregunta = scanner.nextLine();
		System.out.println(" \nGracias, un saludo");
		scanner.close();
		
	}

}
