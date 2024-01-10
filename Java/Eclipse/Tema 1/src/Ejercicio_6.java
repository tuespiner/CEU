import java.util.Scanner;
public class Ejercicio_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("CALCULADORA DE IVA\n\nDinos el precio del articulo sin IVA por favor:");
		float precioNoIva = scanner.nextFloat();
		float precioIVA = (float) (precioNoIva * 1.21);
		System.out.println("\nEl IVA en españa es del 21% asi que el precio de su producto seria de: "+precioIVA+" euros.");
		scanner.close();
	}

}
