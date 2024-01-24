package Ejercicio_33;

public class Repaso {

	public static void main(String[] args) {
		String mensaje = "Hola ¿como estas?";
		Boolean haceSol = true;
		Integer dias = 7;
		System.out.println(mensaje);

		Caballo caballo1 = new Caballo();
		
		caballo1.incrementarCarrerasGanadas();
		caballo1.imprimeCarrerasGanada();
		caballo1.relincha();
		caballo1.setNombre("Bolita");
		System.out.println(caballo1.getNombre());
		
		caballo1.setColor("Marron");
		caballo1.setEdad(2);
		System.out.println(caballo1.getColor());
		System.out.println(caballo1.getEdad());
		System.out.println(caballo1.toString());
		
		Caballo caballo2 = new Caballo("Fideo","Blanco",4,20);
		
		caballo2.imprimeCarrerasGanada();
		System.out.println(caballo2.toString());
		
		Caballo caballo3 = new Caballo();
		
		System.out.println(caballo3.toString());
		
		
	}

}
