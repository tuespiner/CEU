import java.util.Scanner;

public class Ejercicio_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String intro = "";
		String num1 = "";
		String num2 = "";
		int comprobar = 0;
		int posi1 = 0;
		System.out.println("Dime un numero capicua");
		intro = scanner.nextLine();
		int largo = intro.length();
		int posi2 = largo - 1;
		int i = 0;
		do {
			i++;
			num1 = intro.substring(posi1, posi1 + 1);
			num2 = intro.substring(posi2, posi2 +1);
			if (num1.equals(num2)) {
				comprobar++;
			}
			
			posi1++;
			posi2--;
		} while (posi1 < posi2);
		if (comprobar == i) {
			System.out.println("El numero " + intro + " es capicua");
		} else {
			System.out.println("El numero " + intro + " no es capicua");
		}
	}

}
