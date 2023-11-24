import java.util.Scanner;
public class Ejercicio_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] cadenas = new String[3];
		String intro = "";
		System.out.println("dime 3 frases");
		for (int i = 0; i < 3; i++) {
			System.out.println(i+1);
			intro = scanner.nextLine();
			cadenas[i]=intro;
		}
		System.out.println("La concadenación de las 3 cadenas es: "+cadenas[0]+cadenas[1]+cadenas[2]);
		

	}

}
