import java.util.Scanner;

public class Ejercicio_14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("dime tu nombre");
		input = scanner.nextLine();
		String[] nombre= input.split(" ");
		
		System.out.println("Tu nombre es: "+nombre[0]+", Tus apellidos son: "+nombre[1]+" "+nombre[2]);
			
		
	}

}
