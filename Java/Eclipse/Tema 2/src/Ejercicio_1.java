import java.util.Scanner;
public class Ejercicio_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("DINOS TU AÑO DE NACIMIENTO Y CONOCE CUAL ES TU GENERACIÓN");
		
		int añonacimiento = scanner.nextInt();
		
		if ((añonacimiento>= 1883)&&(añonacimiento <= 1900)) {
			System.out.println("Eres de la generacion perdida");
		}
		else if ((añonacimiento>=1901)&&(añonacimiento<=1927)) {
			System.out.println("Eres de la generacion grandiosa");
		}
		else if ((añonacimiento>=1928)&&(añonacimiento<=1945)) {
			System.out.println("Eres de la generacion silenciosa");
		}
		else if ((añonacimiento>=1946)&&(añonacimiento<=1964)) {
			System.out.println("Eres de la generacion Baby Boomers");
		}
		else if ((añonacimiento>=1965)&&(añonacimiento<=1980)) {
			System.out.println("Eres de la generacion X");
		}
		else if ((añonacimiento>=1981)&&(añonacimiento<=1996)) {
			System.out.println("Eres de la generacion Milleniars o Generacion Y");
		}
		else if ((añonacimiento>=1997)&&(añonacimiento<=2012)) {
			System.out.println("Eres de la generacion Zoomers o Generacion Z");
		}
		else if ((añonacimiento>= 2013)&&(añonacimiento<2023)) {
			System.out.println("Eres de la generacion Alfa");
		}
		else {
			System.out.println("Tu generacion no esta en nuestra lista");
		}
		

	}

}
