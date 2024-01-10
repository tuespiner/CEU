import java.util.Scanner;
public class Ejercicio_8_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String mensaje;
		boolean hola = false;
		boolean hastaluego = false;
		
		System.out.println("Dinos una frase empezando con hola y que termine con hastaluego, si no no lo entendera el programa");
		do {
			mensaje = scanner.nextLine();mensaje = mensaje.trim();
			hola = mensaje.startsWith("hola");
			hastaluego = mensaje.endsWith("hastaluego");
			if ((hola != true)||(hastaluego!=true)) {
				System.out.println("no te he entendido, repitelo porfavor");
			}
		}while((hola != true)||(hastaluego != true));
			System.out.println("lo he entendido, mensaje: "+mensaje);

	}

}
