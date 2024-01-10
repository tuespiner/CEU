import java.util.Scanner;
public class Ejercicio_for {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i =0;
		
		for(;i<101;i++) {
			System.out.println(i);
		}
		i = 100;
		for(;i>-1;i--) {
			System.out.println(i);
		}
		i=0;
		for(;i<101;i+=7) {
			System.out.println(i);
		}
		i = 100;
		for(;i>-1;i-=7) {
			System.out.println(i);
		}
		System.out.println("Dame un numero para hacer un contador hasta el numero que dices.");
		int b =scanner.nextInt();
		i=0;
		for(;i<(b+1);i++) {
			System.out.println(i);
		}
	}

}
