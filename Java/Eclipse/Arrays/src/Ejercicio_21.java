
public class Ejercicio_21 {

	public static void main(String[] args) {
		double[] numerosDecimales = new double[]{4.4,3.1,9.0,4.7};
		double suma = 0;
		for(double output : numerosDecimales) {
			System.out.print(output + " ");
		}
		for(double output : numerosDecimales) {
			suma+=output;
		}
		System.out.println("\n"+suma);
	}

}
