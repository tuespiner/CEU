import java.util.Scanner;

public class Ejercicio_24_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intro;
		int par = 0;
		System.out.println("Pon un numero mayor a 0");
		
		do {
			intro = scanner.nextInt();
			if(intro == 0) {
				System.out.println("pon un numero mayor a 0");
			}else {
				System.out.println("muy bien");
			}
		}while(intro == 0);
		for(int i = 0; i != intro; i++) {
			par = i % 2;
			if (par == 0) {
				System.out.print(i+" ");
			}else {
				System.out.print("");
			}
		}
		System.out.println("estos son todos los numeros pares");

	}

}
