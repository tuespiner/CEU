import java.util.Scanner;
public class Ejercicio_5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intentos;
		int[] masGrande = new int[6];
		System.out.println("Cuantos numeros quieres poner");
		intentos = scanner.nextInt();
		int[] bbdd = new int[intentos];
		for(int i= 0; i <intentos; i++) {
			System.out.println("dime el numero "+ (i+1) + " que quieres poner:");
			bbdd[i] = scanner.nextInt();
		}
		masGrande[3]=bbdd[0];
		for(int i = 0; i <intentos;i++) {
			masGrande[0] = bbdd[i];
			if (masGrande[0] >masGrande[1]) {
				masGrande[1] = masGrande[0];
				masGrande[2] = i;
			}
			else if(masGrande[0]<masGrande[3]){
				masGrande[3]=masGrande[0];
				masGrande[4]=i;
			}
		}
		System.out.println("El mas grande es "+masGrande[1]+" y esta en la posición "+ masGrande[2]+ ", el mas pequeño es "+masGrande[3]+" y esta en la posición "+masGrande[4]);
		for(int x = 0; x < intentos; x++) {
			masGrande[5] = masGrande[5]+bbdd[x];
		}
		System.out.println("La media de todos los numeros introducidos es: "+masGrande[5]/intentos);
		scanner.close();
	}

}