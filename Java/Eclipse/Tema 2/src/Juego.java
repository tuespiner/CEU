import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String personaje = "0";
		String intro = "";
		int x = 0;
		int y = 0;
		int xInput = 0;
		int yInput = 0;
		while (intro != "x") {
			for (int i = 0; i != 6; i++) {
				x = i;
				for (int o = 0; o != 6; o++) {
					y = o;
					if (x == xInput) {
						if (y == yInput) {
							System.out.print(personaje + " ");
						} else {
							System.out.print("- ");
						}
						x = i;
					} else {
						System.out.print("- ");
						x = i;
					}
				}
				System.out.println("");
			}
			intro = scanner.nextLine();
			switch (intro) {
			case "a":
				yInput = yInput - 1;
				if (yInput == -1) {
					yInput = yInput + 1;
				}
				break;
			case "d":
				yInput = yInput + 1;
				if (yInput == 6) {
					yInput = yInput - 1;
				}
				break;
			case "w":
				xInput = xInput - 1;
				if (xInput == -1) {
					xInput = xInput + 1;
				}
				break;
			case "s":
				xInput = xInput + 1;
				if (xInput == 6) {
					xInput = xInput - 1;
				}
				break;
			}
		}
	}
}
