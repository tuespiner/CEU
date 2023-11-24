import java.util.Scanner;

public class Ejercicio_13_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		String guardar = "";
		boolean terminar = false;

		do {
			System.out.println("dime un texto constantemente, cuando pongas fin se mostrara todo");
			input = scanner.nextLine();
			guardar = guardar + " " + input;

			if ((input.equalsIgnoreCase("fin")) == true) {
				terminar = true;
			} else {
				terminar = false;
			}

		} while (terminar != true);
		System.out.println(guardar);

	}
}