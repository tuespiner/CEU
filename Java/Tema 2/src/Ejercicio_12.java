import java.util.Scanner;
public class Ejercicio_12 {
		public final static String RESPUESTA = "repita su usuario";
		public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String usuario;
		int espacio;
		int largo;
		boolean comprobador = false;
		
		
		System.out.println("login, por favor escribe tu correo electronico.");
		do {
			usuario = scanner.nextLine();
			usuario = usuario.trim();
			usuario = usuario.toUpperCase();
			espacio = usuario.indexOf(" ");
			largo = usuario.length();
			
			if (espacio >0) {
				System.out.println("su usuario no puede tener espacios\n"+RESPUESTA);
			}
			else if(largo<10) {
				System.out.println("el usuario tiene que tener como minimo 10 caracteres\n"+RESPUESTA);
			}
			else {
				comprobador = true;
			}
			
		}while (comprobador != true);
			System.out.println("Su usuario "+usuario+" es correcto");
	}
}
