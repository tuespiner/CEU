import java.util.Scanner;
public class Ejercicio_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String texto;
		String imprimir;
		int contador = 0;
		int contador2 = 5;
		int contadorIni = contador;
		
		
		System.out.println("Dame un texto porfavor: ");
		texto = scanner.nextLine();
		int largo = texto.length();
		
		while (contador < largo) {
			contador+=1;
			if (contador == contador2) {
				imprimir = texto.substring(contadorIni,contador);
				System.out.println(imprimir);
				contadorIni = contador;
				contador2+=5;
				if (contador2 > largo) {
					contador2=largo;
				}
			}
		}
		
		
		}
}
