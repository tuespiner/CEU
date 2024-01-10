import java.util.Scanner;
public class Ejercicio_4_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Dime tu numero favorito.");
		Integer numfav = scanner.nextInt();scanner.nextLine();
		System.out.println("Dime tu ciudad favorita.");
		String ciudad = scanner.nextLine();
		System.out.println("tu numero favorito es "+numfav +", y tu ciudad favorita es "+ ciudad+".");
		scanner.close();
	}

}


