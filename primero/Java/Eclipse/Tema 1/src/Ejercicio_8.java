import java.util.Scanner;
public class Ejercicio_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("PROGRAMA DE CONVERSIÓN");
		System.out.println("\nDime un numero cualquiera:\n");
		String a = scanner.nextLine();
		System.out.println("\n !!Perfecto¡¡, ahora dinos otro numero pero que sea mas largo:");
		Double b = scanner.nextDouble();
		System.out.println("\n!!Genial¡¡, ahora dinos un tercer numero:");
		Float c = scanner.nextFloat();
		System.out.println("\n!!Perfecto¡¡, ahora van a salir todos esos numeros combertidos en long, string e integer.");
		long x1 = Long.parseLong(a);
		String x2 = b.toString();
		int x3 = b.intValue();
		long x4= c.longValue() ;
		System.out.println("\n Los numeros son: "+x1+", "+x2+", "+x3+", "+x4+".");
		scanner.close();
	}

}
