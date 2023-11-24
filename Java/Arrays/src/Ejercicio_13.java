
public class Ejercicio_13 {

	public static void main(String[] args) {
		int[][] tablas = new int[11][11];
		int multiplicar = 0;
		for (int i = 0; i < tablas.length; i++) {
			for (int x = 0; x < tablas.length; x++) {
				tablas[i][x] = multiplicar * x;
			}
			multiplicar++;
			for (int y = 0; y < tablas.length; y++) {
				if (tablas[i][y] < 10) {
					System.out.print(" " + tablas[i][y] + " ");
				} else {
					System.out.print(" " + tablas[i][y]);
				}
			}
			System.out.println("");
		}

	}

}
