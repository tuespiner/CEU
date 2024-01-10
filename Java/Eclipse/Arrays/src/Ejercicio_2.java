import java.util.Scanner;
public class Ejercicio_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intro = 0;
		int[] numero = new int[6];
		System.out.println("dime un numero profavor");
		intro = scanner.nextInt();
		for(int i = 0;i<6;i++) {
			numero[i] = intro*intro;
			intro++;
		}
		for(int x = 0; x<6; x++) {
			System.out.print(numero[x]+" ");
		}
 	}

}
