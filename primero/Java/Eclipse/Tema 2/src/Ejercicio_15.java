import java.util.Scanner;
public class Ejercicio_15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;
		int multiplicado=0;
		
		System.out.println("dime de que número entero quieres saber su tabla de multiplicar");
		numero = scanner.nextInt();
		
		for (;multiplicado < 11; multiplicado++) {
			System.out.println(numero + " x "+ multiplicado + " = "+ (numero * multiplicado));
		}
	}
}

