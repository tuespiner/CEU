import java.util.Scanner;
public class Ejercicio_18 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;
		
		do {
			System.out.println("Dime un numero del 1 al 12 para decirte a que mes corresponde, escribe 0 para cancelarlo");
			numero = scanner.nextInt();
			if((numero >12)||(numero <0)) {
				System.out.println("el numero tiene que ser del 0 al 12");
			}
			else {
				switch(numero) {
					case 1:
						System.out.println("enero");
						break;
					case 2:
						System.out.println("febrero");
						break;
					case 3:
						System.out.println("marzo");
						break;
					case 4:
						System.out.println("abril");
						break;
					case 5:
						System.out.println("mayo");
						break;
					case 6:
						System.out.println("junio");
						break;
					case 7:
						System.out.println("julio");
						break;
					case 8:
						System.out.println("agosto");
						break;
					case 9:
						System.out.println("septiembre");
						break;
					case 10:
						System.out.println("octubre");
						break;
					case 11:
						System.out.println("noviembre");
						break;
					case 12:
						System.out.println("diciembre");
						break;
					
						
				}
			}
		}while(numero>0);
			System.out.println("Muchas gracias");
	}

}
