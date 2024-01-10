import java.util.Scanner;

public class Ejercicio_9_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String mensaje;
		int espacio = -1;
		String hhastaluego;
		boolean hola = false;
		boolean hastaluego = false;
		boolean adios = false;
		boolean terminar = false;
		boolean cierto = false;

		System.out.println(
				"Dinos una frase empezando con hola y que termine con hastaluego, si no no lo entendera el programa, si ponemos adios despoues del hastaluego se cerrara el programa y te dira el mensaje");
		do {
			mensaje = scanner.nextLine();
			mensaje = mensaje.trim();
			espacio = mensaje.lastIndexOf(" ");
			adios = mensaje.endsWith("adios");
			if (adios == true) {

				hhastaluego = mensaje.substring(0, espacio);
				hola = hhastaluego.startsWith("hola");
				hastaluego = hhastaluego.endsWith("hastaluego");
				if ((hola != true) || (hastaluego != true)) {
					System.out.println("no te he entendido, repitelo porfavor");
					cierto = false;
				} else {
					System.out.println("entendido");
					cierto = true;
					if (cierto == true) {
						terminar = true;
					}else {
						System.out.println("Repitelo, para terminar pon al final adios");
					}
				}
			} else {
				hola = mensaje.startsWith("hola");
				hastaluego = mensaje.endsWith("hastaluego");
				if ((hola != true) || (hastaluego != true)) {
					System.out.println("no te he entendido, repitelo porfavor");
				} else {
					System.out.println("entendido");
					System.out.println("Repitelo, para terminar pon al final adios");
				}
			}
		} while (terminar != true);
		System.out.println("lo he entendido, mensaje: " + mensaje);

	}
}

