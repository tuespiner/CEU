import java.util.Scanner;
public class aprovado {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Dinos la nota de programación: ");
		int numero = scanner.nextInt();
		
		if (numero >= 5&&numero < 7 ){
			System.out.println("!Estas aprobado¡");
		}
		else if(numero >= 7 && numero < 9 ){
			System.out.println("!Tienes un notable¡");
		}
		else if(numero >= 9 && numero <= 10) {
			System.out.println("!TIENES UN SOBRESALIENTE¡");
		}
		else{
			System.out.println("Estas suspenso");
		}
		scanner.close();
	}

}
