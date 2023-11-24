import java.util.Random;
import java.util.Scanner;

public class Ejercicio_20 {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		String[] Frase = new String[] { "azulejo", "tenedor", "saltamontes", "carretilla", "molinero", "sofisticado",
				"terremoto", "culinario", "teclado", "primavera" };
		boolean terminar = false;
		boolean _no = true;
		String input = "";
		int ia = 0;
		int posicion_input = 0;
		String letra_acertada = "";
		int contador_fallos = 0;
		do {
			if (terminar == false) {
				ia = random.nextInt(0, 10);
				String[] Frase2 = new String[Frase[ia].length()];
				Frase2[0]=Frase[ia].substring(0,1);
				System.out.print(Frase2[0]);
				for (int i = 1; i < Frase[ia].length(); i++) {
					Frase2[i] = "_";
					System.out.print(" "+Frase2[i]);
				}
				do {
					System.out.println("\n\nDime una letra que creas que pueda estar en esta palabra");
					input = scanner.nextLine();
					if (Frase[ia].contains(input)) {
						do {
							posicion_input = Frase[ia].indexOf(input);
							Frase2[posicion_input] = input;
							letra_acertada = Frase[ia].substring(0, posicion_input) + "_" + Frase[ia].substring(posicion_input+1 , Frase[ia].length() );
							Frase[ia] = letra_acertada;
						} while (Frase[ia].contains(input));
					} else {
						System.out.println(input+" no esta en la palabra");
						contador_fallos++;
					}
					posicion_input = 0;
					for(int i = 0; i<Frase2.length;i++) {
						if (Frase2[i].equals("_")) {
							posicion_input = 1;
							System.out.print(" "+Frase2[i]);
						}else {
							System.out.print(" "+Frase2[i]);
						}
					}
					if(posicion_input == 1 || contador_fallos >= 10) {
						_no = true;
					}else {
						_no = false;
					}
				} while (_no == true);

			}
			System.out.println("\nJuego terminado\n¿Quieres hacer otro ?");
			input = scanner.nextLine();
			if (input.trim().equalsIgnoreCase("si")) {
				terminar = false;
			}else {
				break;
			}

		} while (terminar == false);

	}

}
