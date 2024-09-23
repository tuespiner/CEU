import java.util.Scanner;
public class Ejercicio_3_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce dos numeros muy grandes para multiplicarlos:");
		String num1 =  scanner.nextLine();
		String num2 = scanner.nextLine();
		Float num1float = Float.parseFloat(num1);
		Float num2float = Float.parseFloat(num2);
		float multiplicacion = (float) (num1float * num2float);
		System.out.println("La multiplicacion es: "+multiplicacion);
		scanner.close();
	}

}
