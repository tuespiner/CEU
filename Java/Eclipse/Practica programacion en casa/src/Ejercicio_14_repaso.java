import java.util.Scanner;
public class Ejercicio_14_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String texto;
		
		System.out.println("dinos un texto y crearemos una contrasseña");
		texto = scanner.nextLine();
		texto = texto.replaceAll(" ", "");
		texto = texto.replaceAll("a", "4");
		texto = texto.replaceAll("e", "3");
		texto = texto.replaceAll("i", "1");
		texto = texto.replaceAll("o", "0");
		texto = texto.replaceAll("t", "7");
		System.out.println("su contraseña es: "+texto);
		
		

	}

}
