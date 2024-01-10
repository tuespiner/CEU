import java.util.Scanner;
public class Ejercicio_20 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int  y= 1;
		int  x= 1;
		int input1;
		int input2;
		System.out.println("dime el nuemro de la x");
		input1 = scanner.nextInt();
		System.out.println("ahora dime el numero de la y");
		input2 = scanner.nextInt();
		
		
		for(;y<=input2;y++) {
			for(;x<=input1;x++) {
				System.out.print(x+" ");
				
			}
			System.out.println("");
			x=1;
		}
				
		

	}

}
