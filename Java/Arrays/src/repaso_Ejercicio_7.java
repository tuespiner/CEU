import java.util.Scanner;

public class repaso_Ejercicio_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String telegrama = "";
		float precioTelegrama = 0;
		
		System.out.println("Escribe tu telegrama");
		telegrama = scanner.nextLine();
		
		String[] telegramaContar = telegrama.split(" ");
		
		for(String palabra : telegramaContar) {
			if((palabra.equalsIgnoreCase("stop"))) {
				precioTelegrama +=0;
			}else {
				precioTelegrama += 0.24;
			}
		}
		System.out.println("El precio del telegrama es: "+precioTelegrama);
	}

}
