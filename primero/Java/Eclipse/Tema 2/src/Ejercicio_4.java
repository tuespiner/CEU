import java.util.Scanner;
public class Ejercicio_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 System.out.println("CUENTA ACUMULATIVA DE NUMEROS, CUANDO PONGAS 0 SE DEJARA DE SUMAR\nEscribe un numero");
		 double cuentaAcumulativa = 0;
		 double numeroIntroducido= 0;
		 
		 do {
			 numeroIntroducido = scanner.nextDouble();
			 cuentaAcumulativa += numeroIntroducido;
			 if(numeroIntroducido != 0) {
				 System.out.println("escribe otro numero");
			 }
		 }while (numeroIntroducido != 0);
		 	System.out.println("Su cuenta acumulativa tiene este numero: "+cuentaAcumulativa);
		 
		 
	}	

}
