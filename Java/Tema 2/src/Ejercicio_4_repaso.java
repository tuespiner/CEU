import java.util.Scanner;
public class Ejercicio_4_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cantidad = 0;
		double precio = 0;
		double precioTotal = 0;
		
		System.out.println("Dime la cantidad de unidades que has comprado:");
		cantidad = scanner.nextInt();
		System.out.println("Dime el precio de las unidades:");
		precio = scanner.nextInt();
		precioTotal = precio * cantidad;
		if(cantidad<10) {
			System.out.println("El precio total es de "+precioTotal+", no se aplica descuento");
		}
		else if ((cantidad >=10)&&(cantidad <24)) {
			precioTotal=precioTotal*0.9;
			System.out.println("El precio total es de "+precioTotal+", tienes un descuento del 10% ");
		}
		else if((cantidad >= 24)&&(cantidad <100)) {
			precioTotal = precioTotal*0.8;
			System.out.println("El precio total es de "+ precioTotal+", tienes un descuento del 20%");
		}
		else {
			precioTotal = precioTotal*0.6;
			System.out.println("El precio total es de "+precioTotal+", tienes un descuento del 40%");
		}
	}

}
