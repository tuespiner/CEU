import java.util.Scanner;
public class Ejercicio_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("CALCULADORA DE MASA CORMPORAL\nDinos tu peso porfavor:");
		float peso= scanner.nextFloat();
		System.out.println("\n!!Perfecto¡¡, ahora dinos tu altura porfavor:");
		float altura = scanner.nextFloat();
		System.out.println("\n!!Perfecto¡¡");
		double alturaAlCuadrado = Math.pow(altura, 2);
		float altura2 = (float) alturaAlCuadrado;
		float imc = (float) (peso / altura2);
		System.out.println("\n\nSu IMC es de : "+imc);
		scanner.close();
	}

}
