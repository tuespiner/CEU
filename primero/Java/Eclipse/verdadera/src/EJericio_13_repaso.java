import java.util.Scanner;

public class EJericio_13_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		String guardar = "";
		boolean terminar = false;

		do {
			System.out.println("dime un texto constantemente, cuando pongas fin se mostrara todo");
			input = scanner.nextLine();
			input = input.trim();
			input = input.toLowerCase();
			guardar = guardar + " " + input;

			if ((input.contains("fin")) == true) {
				terminar = true;
			} else {
				terminar = false;
			}

		} while (terminar != true);
		System.out.println(guardar);

	}
}