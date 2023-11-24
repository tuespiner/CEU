import java.util.Scanner;

public class Ejercicio_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float precioIVA;
		float iva1 =(float) 1.21;
		float iva2 = (float) 1.10;
		float iva3 = (float) 1.04;
		
		System.out.println("CALCULADORA DE IVA\n\nDinos el precio del articulo sin IVA por favor:");
		float precioNoIva = scanner.nextFloat();
		System.out.println("Dinos que tipo de IVA usa tu pais\n  1. Normal: 21%\n  2. Reducido: 10%\n  3. Superreducido: 4%\n  4. Exento: 0%.");
		int tipoIva = scanner.nextInt();
		
		if (tipoIva == 1) {
			precioIVA = (float) precioNoIva * iva1;
			System.out.println("\nEl precio de su producto seria de: "+precioIVA+" euros.");
		}
		else if (tipoIva == 2) {
			precioIVA = (float) precioNoIva * iva2;
			System.out.println("\nEl precio de su producto seria de: "+precioIVA+" euros.");
		}
		else if (tipoIva == 3) {
			precioIVA = (float) precioNoIva * iva3;
			System.out.println("\nEl precio de su producto seria de: "+precioIVA+" euros.");
		}
		
		else if (tipoIva == 4) {
			precioIVA = precioNoIva;
			System.out.println("\nEl precio de su producto seria de: "+precioIVA+" euros.");
		}
		else {
			System.out.println("No existe esa opción");
		}
		
		
		
		
		
		
		scanner.close();
	}

}