
public class repaso_Ejercicio_5 {

	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] {7,9,8,4,0,6,3,4,1,7,3,1,9,10};
		int contador = 0;
		for(int notas : listaNotas) {
			if( notas <5) {
				listaNotas[contador] = 5;
			}
			contador++;
		}
		System.out.print("Lista notas:");
		for(int notas : listaNotas) {
			System.out.print(" "+notas);
		}
		
	}

}
