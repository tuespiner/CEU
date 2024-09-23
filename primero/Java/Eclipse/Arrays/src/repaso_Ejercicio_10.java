import java.util.Scanner;

public class repaso_Ejercicio_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Cuantos alumnos hayen clase?");
		String[][] NotaAlumnos = new String[scanner.nextInt()][4];
		scanner.nextLine();
		for (int i = 0; i < NotaAlumnos.length; i++) {
			System.out.println("Cual es el nombre del alumno "+(i+1));
			NotaAlumnos[i][0] = scanner.nextLine();
			for (int y = 1; y <= 3; y++) {
				System.out.println("Cual es la nota de "+NotaAlumnos[i][0]+" para el examen " + y);
				NotaAlumnos[i][y] = scanner.nextLine();
			}
		}
		System.out.println("LISTADO DE NOTAS:");
		int[] suma = new int[NotaAlumnos.length+1];
		for(int i = 0; i<NotaAlumnos.length;i++) {
			for(int y = 1; y<NotaAlumnos[i].length;y++) {
				suma[i] += Integer.parseInt(NotaAlumnos[i][y]);
			}
			suma[NotaAlumnos.length]+=suma[i]/3;
			System.out.println("Alumno: "+NotaAlumnos[i][0]+" - Nota media: "+suma[i]/3);
		}
		System.out.println("Media de los alumnos: "+(suma[NotaAlumnos.length]/NotaAlumnos.length));
	}

}
