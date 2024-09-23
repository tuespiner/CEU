import java.util.Scanner;

public class pruebajhonatan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String intro = "";
		int longitud;
		String letra = "";
		intro = scanner.nextLine();
		longitud = intro.length();
		for(int i = 0;i != longitud;i++) {
			letra = intro.substring(i,(i+1));
			System.out.println(letra);
		}
		}
	}

