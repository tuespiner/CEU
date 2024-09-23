import java.util.Scanner;
public class Ejercicio_4 {
	public static final int AÑO = 2023;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Dinos su año de nacimiento porfavor");
		int añoDeNacimiento = scanner.nextInt();
		int añosDelUsuario = AÑO - añoDeNacimiento;
		System.out.println("\nTienes "+añosDelUsuario+" años");
		scanner.close();
	}

}
