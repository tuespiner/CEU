import java.util.Scanner;

public class Ejercicio_10_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String url;
		String print;
		int respuesta = 1;
		int localizacion1 = 0;
		int localizacion2 = 0;

		System.out.println("Dime la URL de la web que quieres dividir (ej https://www.google.com)");
		url = scanner.nextLine();

		localizacion1 = url.indexOf(".");
		localizacion2 = url.lastIndexOf(".");
		if (localizacion1 != localizacion2) {
			for (; respuesta <= 4; respuesta++) {
				if (respuesta <= 1) {
					localizacion1 = url.indexOf("//");
					System.out.println(print = url.substring(0, localizacion1));
				} else if (respuesta == 2) {
					localizacion2 = url.indexOf(".");
					System.out.println(print = url.substring((localizacion1 + 2), localizacion2));
				} else if (respuesta == 3) {
					localizacion1 = url.lastIndexOf(".");
					System.out.println(print = url.substring((localizacion2 + 1), localizacion1));
				} else {
					localizacion2 = url.length();
					System.out.println(print = url.substring((localizacion1 + 1), localizacion2));

				}
			}
		} else {
			System.out.println("tiene que haber 2 puntos si o si");
			respuesta = 4;
		}

	}

}
