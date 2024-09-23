package Ejercicio_44;

public class App {

	public static void main(String[] args) {
		Equipo equipo1 = new Equipo();
		Jugador jugador1 = new Jugador(); // Creamos el jugador
		jugador1.setNombre("pepitogamer777");
		
		// Creamos los 3 asesinos
		
		Asesinos asesino1 = new Asesinos();
		asesino1.setCodigo("B01");
		asesino1.setNombre("Lucas");
		equipo1.añadirPersonaje(asesino1);
		
		Asesinos asesino2 = new Asesinos();
		asesino1.setCodigo("B02");
		asesino1.setNombre("Luis");
		equipo1.añadirPersonaje(asesino2);
		
		Asesinos asesino3 = new Asesinos();
		asesino1.setCodigo("B03");
		asesino1.setNombre("Juan");
		equipo1.añadirPersonaje(asesino3);
		jugador1.setEquipo(equipo1);
		
		// Creamos el parasito blas
		
		Parasitos parasito1 = new Parasitos();
		parasito1.setCodigo("B69");
		parasito1.setNombre("Blas");
		
		// Mostramos el daño y la frecuencia
		
		System.out.println("Hace " + parasito1.getDaño() + " de daño cada " + parasito1.getFrecuencia() + " segundos");
		
		jugador1.getEquipo().añadirPersonaje(parasito1);
		
		System.out.println(equipo1);
		

	}

}
