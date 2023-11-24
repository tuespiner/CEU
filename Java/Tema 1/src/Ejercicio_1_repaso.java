import java.util.Scanner;
public class Ejercicio_1_repaso {
	public static final float PI = (float) 13.14;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("CALCULADORA DE AREA DE UN CIRCULO\nDinos el radio de un circulo en cm");
		float radio = scanner.nextFloat();
		System.out.println("\nCalculando...");
		float circunferencia = (float) 2 * PI * radio;
		float radioalcuadrado =(float) Math.pow(radio,2);
		float area = PI * radioalcuadrado;
		System.out.println("\nCircunferencia: "+circunferencia+"cm, area: "+area+"cm^2.");
		scanner.close();
	}

}
