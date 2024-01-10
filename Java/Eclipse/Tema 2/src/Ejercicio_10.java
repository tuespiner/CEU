import java.util.Scanner;
public class Ejercicio_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cad1;
		String cad2;
		int compara;
		boolean comprovador1;
		boolean comprovador2;
		System.out.println("Dame dos cadenas que no esten vacias ni con solo espacios");
		do {
			System.out.println("Dame la primera cadena: ");
			cad1 = scanner.nextLine();
			comprovador1 = cad1.isBlank();
			cad1 = cad1.trim();
			System.out.println("Dame la segunda cadena: ");
			cad2 = scanner.nextLine();
			comprovador2 = cad2.isBlank();
			cad2 = cad2.trim();
			
			if ((comprovador1 != false) && (comprovador2 != false)) {
				System.out.println("No se ha introducido ningun valor\n\n");
			}
			else if(comprovador1 != false){
				System.out.println("No se ha introducido el primer valor\n\n");				
			}
			else if(comprovador2 != false) {
				System.out.println("No se ha introducido el segundo valor\n\n");
			}
		}while(((comprovador1 == true) && (comprovador2 == false))||((comprovador1 == false) && (comprovador2 == true)));
			 System.out.println("Todos los valores han sido introducidos\n\n");
			 compara = cad1.compareTo(cad2);
			 if (compara <= 0) {
				 System.out.println(cad1 + " " + cad2);
			 }
			 else if (compara >0) {
				 System.out.println(cad2 + " " + cad1);
			 }
			 
		
	}

}
