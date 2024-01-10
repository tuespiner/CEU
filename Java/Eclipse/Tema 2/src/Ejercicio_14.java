import java.util.Scanner;
public class Ejercicio_14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;
		int multiplicado=0;
		int resultado;
		System.out.println("dime de que número entero quieres saber su tabla de multiplicar");
		numero = scanner.nextInt();
		
		while(multiplicado <11) {
			resultado = numero * multiplicado;
			System.out.println(numero + " x "+multiplicado+" = "+resultado);
			multiplicado++;
		}
	}
}
