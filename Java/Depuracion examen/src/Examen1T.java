import java.util.Scanner;

public class Examen1T {
	
	public static void main(String[] args) {
	
		String mensaje = "10 de Noviembre de 2023";		
		int num1, num2, num3;
		
		Scanner lectura = new Scanner (System.in);
		System.out.println("Introduce un numero entero:");
		num1 = lectura.nextInt();
		System.out.println("Introduce un segundo número entero:");
		num2 = lectura.nextInt();
		lectura.close();
		
		System.out.println("Primer numero introducido: " + num1);
		System.out.println("Segundo numero introducido " + num2);
		if (num1 <= num2) {
			//num3=num1/num2; tiene que ser al reves la division
			num3=num2/num1;
			System.out.println("El cociente de la división del mayor entre el menor es " + num3);
		}else {
			num3=num1/num2;
			System.out.println("El cociente de la división del mayor entre el menor es " + num3);
		}
		
		int i=0;
		System.out.println();
		// while (1<mensaje.length()-1), el -1 esta no tendria que estar
		while (i<mensaje.length())  
		{
			String derecho= mensaje.substring(i,i+1);
			System.out.print(derecho);
			i++;
		}  
		System.out.println();
		
		i = mensaje.length()-1;
		String reves=""; 
		while (i>=0)
		{	
			 reves= mensaje.substring(i,i+1);	
			 System.out.print(reves);
			 i--;
		}
		//System.out.print(reves); tiene que estar dentro del bucle
	}
}