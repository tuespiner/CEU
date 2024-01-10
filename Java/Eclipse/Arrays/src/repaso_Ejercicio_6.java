
public class repaso_Ejercicio_6 {

	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] {7,9,8,4,0,6,3,4,1,7,3,1,9,10};
		int contador = 0;
		for(int notas : listaNotas) {
			if( contador % 2 == 0) {
				listaNotas[contador] = (notas*2);
			}
			contador++;
		}
		System.out.print("Lista notas:");
		for(int notas : listaNotas) {
			System.out.print(" "+notas);
		}
		
	}

}