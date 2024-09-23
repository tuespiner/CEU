package Ejercicio_2_repaso;

public class App {

	public static void main(String[] args) {
		Movil movil1 = new Movil(654654654,"mi casa");
		Fijo fijo1 = new Fijo(954954954, "C/ mi casa nº13");
		
		System.out.println(movil1.consultarNumero());
		System.out.println(fijo1.consultarNumero());
		
		movil1.marcar(654654654);
		movil1.marcar(610610610);
		movil1.colgar();
		movil1.colgar();
		
		
	}

}
