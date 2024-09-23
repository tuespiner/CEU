import java.util.Scanner;

public class repaso_Ejercicio_9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime tu html");
		String input = scanner.nextLine();
		String[] html_separado = input.split(">");
		System.out.println("Frase: ");
		for(String separado : html_separado) {
			if(separado.indexOf("<")!=0) {
				String[] quitar_etiqueta = separado.split("<");
				System.out.println(quitar_etiqueta[0]);
			}
		}

	}

}