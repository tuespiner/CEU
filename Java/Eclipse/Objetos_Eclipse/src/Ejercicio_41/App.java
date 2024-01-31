package Ejercicio_41;

public class App {

	public static void main(String[] args) {
		Jugador jugador1 = new Jugador("Juan", 13);
		Jugador jugador2 = new Jugador("Lucas",12);
		Jugador jugador3= new Jugador("Luis", 15);
		Equipo betis = new Equipo("Betis");
		
		betis.setJugadores(jugador1);
		betis.setJugadores(jugador2);
		betis.setJugadores(jugador3);
		
		System.out.println(jugador1.equals(jugador2));
		System.out.println(jugador1.toString());
		
		for(Jugador jugador : betis.getJugadores()) {
			System.out.println(jugador);
		}
		System.out.println(betis);

	}

}
