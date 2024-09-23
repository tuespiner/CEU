import java.util.Scanner;
public class Ejercicio_3_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		
		while(opcion!= 4) {
			opcion = 0;
			System.out.println("*** MENú ***\n   1. Abrir\n   2. Guardar\n   3. Modificar\n   4. Salir");
			opcion = scanner.nextInt();
			switch (opcion) {
				case 1:
					System.out.println("Opción 1: abrir");
					break;
				case 2:
					System.out.println("Opción 2: guardar");
					break;
				case 3:
					System.out.println("Opción 3: modificar");
					break;
				case 4:
					System.out.println("Opción 4: Salir");
					break;
					
		}
		}
	}	

}
