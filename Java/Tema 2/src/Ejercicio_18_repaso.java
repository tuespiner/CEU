import java.util.Scanner;
public class Ejercicio_18_repaso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String intro;
		int total = 0;
		System.out.println("Pon un texto y te lo pondremos al reves");
		intro = scanner.nextLine();
		total = intro.length();
		for(;total > 0;total--) {
			System.out.print(intro.substring((total-1),total));
			
		}
	}
}
