
public class Ejercicio_6_repaso {

	public static void main(String[] args) {
		int numSuma=0;
		int suma=0;
		for(;numSuma<=30;numSuma=numSuma+3) {
			System.out.print(numSuma+" + ");
			suma +=numSuma;
		}
		System.out.println("= "+suma);
	}

}
