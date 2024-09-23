import java.util.Scanner;

public class Ejercicio_15 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String url = "";
		boolean terminar = false;
		System.out.println("Dime una url porfavor");
		while (terminar != true) {
			url = scanner.nextLine();
			if (url.contains("://") && url.indexOf(".") < url.lastIndexOf(".")) {
				String[] urlSeparada = url.split("://");
				String[] urlSeparada2 = urlSeparada[1].split("\\.");
				System.out.println(urlSeparada[0]+"://");
				System.out.println(urlSeparada2[0]);
				System.out.println(urlSeparada2[1]);
				System.out.println(urlSeparada2[2]);
				terminar = true;
			} else {
				System.out.println("La url no tiene el formato correcto tiene que ser asi: https://www.google.com, repitela");
			}
		}

	}

}
