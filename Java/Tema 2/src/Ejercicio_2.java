import java.util.Scanner;
public class Ejercicio_2 {

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
		
		if (imc<18.5) {
			System.out.println("Tu peso es inferior a el normal");
		}
		else if ((imc >= 18.5)&&(imc <= 24.9 )) {
			System.out.println("Tu peso es normal");
		}
		else if ((imc >= 25)&&(imc <= 29.9 )) {
			System.out.println("Tu peso es superior al normal");
		}
		else {
			System.out.println("Tienes obesidad");
		}
		
		
		
		scanner.close();
	}

}
