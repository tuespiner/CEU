import java.util.Scanner;
public class Ejercicio_18 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		int x = 0;
		boolean comprobador = true;
		System.out.println("Dime un numero capicua");
		String[] capicua = scanner.nextLine().split("");
		x = capicua.length-1;
		do {
			if (capicua[i].equals(capicua[x])) {
				i++;
				x--;
			}else {
				comprobador=false;
				break;
			}
		}while (i<x);
		
		if(comprobador == true) {
			System.out.print("el numero: ");
			for(String numero : capicua) {
				System.out.print(numero);
			}
			System.out.print(" es capicua");
		}else {
			System.out.print("el numero: ");
			for(String numero : capicua) {
				System.out.print(numero);
			}
			System.out.print(" no es capicua");
		}
	}
}
