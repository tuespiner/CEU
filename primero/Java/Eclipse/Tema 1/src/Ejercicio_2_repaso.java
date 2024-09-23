import java.util.Scanner;
public class Ejercicio_2_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce dos numeros muy grandes para multiplicarlos:");
		float num1 = (float) scanner.nextFloat();
		Double num2 = scanner.nextDouble();
		float multiplicacion = (float) (num1 * num2);
		System.out.println("La multiplicacion es: "+multiplicacion);
		scanner.close();
	}

}
