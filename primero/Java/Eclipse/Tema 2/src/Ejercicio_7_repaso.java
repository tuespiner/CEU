import java.util.Scanner;
public class Ejercicio_7_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int suma=0;
		int multiplo;
		System.out.println("introduce un multiplo");
		multiplo = scanner.nextInt();
		int numSuma=multiplo;
		System.out.print("0");
		for(;numSuma<=(multiplo*10);numSuma=numSuma+multiplo) {
			System.out.print(" + "+numSuma);
			suma +=numSuma;
		}
		System.out.println("= "+suma);
	}

}