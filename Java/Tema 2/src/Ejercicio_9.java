import java.util.Scanner;
public class Ejercicio_9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nombreYApellido = "";
		String nombre = "";
		int nombre1 = 0;
		String apellido1 = "";
		int apellido11 = 0;
		String apellido2 = "";
		int apellido22 = 0;
		int longitud;
		
		System.out.println("dime tu nomrbe y tu apellido");
		nombreYApellido = scanner.nextLine();
		nombreYApellido = nombreYApellido.trim();
		longitud = nombreYApellido.length();
		nombre1 = nombreYApellido.indexOf(" ");
		nombre = nombreYApellido.substring(0,nombre1);
		nombre = nombre.trim();
		System.out.println("Tu nombre es: "+nombre);
		apellido11 = nombreYApellido.lastIndexOf(" ");
		apellido1 = nombreYApellido.substring((nombre1 + 1),apellido11);
		System.out.println("Tu primer apellido es: "+apellido1);
		apellido2 = nombreYApellido.substring((apellido11 + 1),longitud);
		System.out.println("Tu segundo apellido es: "+apellido2);
	}

}
