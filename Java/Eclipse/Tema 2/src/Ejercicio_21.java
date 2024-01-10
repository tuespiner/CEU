
public class Ejercicio_21 {

	public static void main(String[] args) {
		int contador1 = 0;
		int contador2 = 1;
		int contador3 = 0;
		int baja;
		
		for(;contador1<=9;contador1++) {
			for(;contador2<=(contador1-1);contador2++) {
				contador3++;
				System.out.print(contador3+" ");
			}
			contador3=0;
			contador2=0;
			System.out.println("");
		}

	}

}
