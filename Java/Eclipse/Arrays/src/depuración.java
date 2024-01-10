
import java.util.Scanner;

public class depuración {

	private static Scanner lectura;

	public static int mcd(int num1, int num2) {
		while(num1 != num2)
			if(num2<num1)
				num1= num1-num2;
			else
				num2= num2 -num1;
		return num1;    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		int numero2;
		int mcdiv;
		lectura = new Scanner (System.in);
		System.out.println("Introduce un numero entero:");
		numero = lectura.nextInt();
		System.out.println("Introduce un segundo entero:");
		numero2 = lectura.nextInt();
		System.out.println("Primer numero introducido: " + numero);
		System.out.println("Segundo numero introducido " + numero2);
	    System.out.println("El doble de " + numero + " es "+ 2*numero);
	    System.out.println("El triple de " + numero + " es "+ 3*numero);
	    mcdiv=mcd(numero, numero2);
	    System.out.println("El maximo comun divisor de " + numero +" y " + numero2 +" es " + mcdiv );
	}
}