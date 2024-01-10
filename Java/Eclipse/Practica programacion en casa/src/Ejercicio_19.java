import java.util.Scanner;
public class Ejercicio_19 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero=0;
		float precio;
		
		System.out.println("CALCULADORA DE IVA\nDinos el precio del produco al que quieres calcular el IVA: ");
		precio = scanner.nextFloat();
		System.out.println("Dinos ahora el tipo de IVA que tiene su producto: \n1: Normal: 21%\n2: Reducido: 10%\n3: Superreducido: 4%\n4: Exento: 0%");
		numero = scanner.nextInt();
		
		switch(numero) {
			case 1:
				System.out.println("Normal 21%, el precio de su producto con IVA seria de: "+(precio * 1.21));
				break;
			case 2:
				System.out.println("Normal 21%, el precio de su producto con IVA seria de: "+(precio * 1.10));
				break;
			case 3:
				System.out.println("Normal 21%, el precio de su producto con IVA seria de: "+(precio * 1.04));
				break;
			case 4:
				System.out.println("Normal 21%, el precio de su producto con IVA seria de: "+precio);
				
			
		}
		

	}

}
