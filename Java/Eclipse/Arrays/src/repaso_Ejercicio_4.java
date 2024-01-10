import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class repaso_Ejercicio_4{

	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] {7,9,8,4,0,6,3,4,1,7,3,1,9,10};
		Scanner scanner = new Scanner(System.in);
		
		int input = 0;
		int contador = 0;
		System.out.println("¿Que nota buscas?");
		input = scanner.nextInt();
		
		for( int nota : listaNotas) {
			if (nota > input) {
				contador++;
			}
		}
		System.out.println("Hay "+contador+" notas mayores a " + input);

	}

}
