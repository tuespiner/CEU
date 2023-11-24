import java.util.Scanner;

public class Ejercicio_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDeFibonnacci = 0;
		boolean terminar = false;
		do {
		System.out.println("Escribe hasta que numero de fibonnacci quieres saber y te lo imprimire por pantalla, tiene que ser mayor que 2");
		nDeFibonnacci = scanner.nextInt();
		}while(nDeFibonnacci <2);
		int[] fibonnaci = new int[nDeFibonnacci+3];
		fibonnaci[1]=1;
		for (int i = 0;terminar != true ; i++) {
				fibonnaci[i+2]= fibonnaci[i]+fibonnaci[i+1];
				if (i == nDeFibonnacci-1) {
					terminar = true;
				}
		}
		System.out.print(fibonnaci[0]);
		for(int i = 1; i < nDeFibonnacci; i++) {
			System.out.print(" + " + fibonnaci[i]);
		}
	}

}
