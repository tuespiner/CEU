import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class repaso_Ejercicio_3 {

	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] {7,9,8,4,0,6,3,4,1,7,3,1,9,10};
		Scanner scanner = new Scanner(System.in);
		int cantidadDeNota = 0;
		System.out.println("Dime la nota que quieres consultar");
		int nota = scanner.nextInt();
		int posicion = 0;
		int posicion2 = 0;
		
		for(int i : listaNotas) {
			if (i == nota) {
				cantidadDeNota++;
			}
		}
		if(cantidadDeNota ==0) {
			System.out.println("La nota "+nota+" no esta");
		}else {
			Integer[] posicionNota = new Integer[cantidadDeNota];
			for(int i : listaNotas) {
				posicion++;
				if (i == nota) {
					posicionNota[posicion2]=posicion;
					posicion2++;
				}
			}
			System.out.print("La nota: " + nota + " esta y estas son sus posiciones: ");
			for(int i : posicionNota) {
				System.out.print(i + " ");
			}
		}

	}

}
