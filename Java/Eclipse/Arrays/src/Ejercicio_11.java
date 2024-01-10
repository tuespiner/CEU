
public class Ejercicio_11 {

	public static void main(String[] args) {
		int[][] array = new int[5][10];
		int contador = 0;

		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array[i].length; x++) {
				contador++;
				array[i][x] = contador;
			}

			for (int y = 0; y <= 9; y++) {
				if (array[i][y] < 10) {
					System.out.print(" " + array[i][y] + " ");
				} else {
					System.out.print(" " + array[i][y]);
				}
			}
			System.out.println("");
		}
	}

}
