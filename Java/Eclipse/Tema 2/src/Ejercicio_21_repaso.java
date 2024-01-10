import java.util.Scanner;
public class Ejercicio_21_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intro = 0;
		String barra = "-";
		String estrella = "*";
		int posiEstrella = 0;
		do {
			System.out.println("\n\nintroduce un numero que sea mayor a 0");
			intro = scanner.nextInt();
		}while(intro == 0);
		for(int i = 0; i != intro; i++) {
			for(int x = 0;x != intro; x++) {
				if (posiEstrella != x) {
					System.out.print(barra+" ");
				}else {
					System.out.print(estrella +" ");
				}
			}
			posiEstrella+=1;
			System.out.println("");
		}

	}

}
