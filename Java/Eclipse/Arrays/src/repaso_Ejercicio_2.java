
public class repaso_Ejercicio_2 {

	public static void main(String[] args) {
		Integer[] listaNotas = new Integer[] {7,9,8,4,0,6,3,4,1,7,3,1,9,10};
		int contador = 0;
		int aprobados = 0;
		for(int i = 0; i<listaNotas.length;i++) {
			if (listaNotas[i]<5) {
				contador++;
			}else {
				aprobados += listaNotas[i];
			}
			
		}
		for(int i : listaNotas) {
			if (i>=5) {
				aprobados += i;
			}
			
		}
		System.out.println("la media de aprovados es: "+(aprobados / (listaNotas.length - contador)));
	}

}
