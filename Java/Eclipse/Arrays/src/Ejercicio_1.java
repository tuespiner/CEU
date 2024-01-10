
public class Ejercicio_1 {

	public static void main(String[] args) {
		int[] pares = new int[15];
		int posi= 0;
		for(int i= 1; i<= 30; i++) {
			if(i%2==0) {
				pares[posi] = i;
				posi++;
			}
		}
		for (int x = 0;x< pares.length;x++){
			System.out.print(pares[x]+" ");
		}
		
	}

}
