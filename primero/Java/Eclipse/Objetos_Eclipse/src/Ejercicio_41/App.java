package Ejercicio_41;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Equipo betis = new Equipo("betis");
		Equipo sevilla = new Equipo("sevilla");
		for(int i = 0; i<3; i++) {
			Jugador jugador = new Jugador("",0);
			if(i == 0) {
				System.out.println("Dime el nombre del capitán");
				jugador.setNombre(sc.nextLine());
				System.out.println("Dime el dorsal del capitán");
				jugador.setDorsal(sc.nextInt());
				sc.nextLine();
				betis.setCapitan(jugador);
			}else {
				System.out.println("dime el nombre del siguiente jugador");
				jugador.setNombre(sc.nextLine());
				System.out.println("Dime el dorsal del siguiente jugador");
				jugador.setDorsal(sc.nextInt());
				sc.nextLine();
				betis.setJugadores(jugador);
			}
			
		}
		for(int i = 0; i<3; i++) {
			Jugador jugador = new Jugador("",0);
			if(i == 0) {
				System.out.println("Dime el nombre del capitán");
				jugador.setNombre(sc.nextLine());
				System.out.println("Dime el dorsal del capitán");
				jugador.setDorsal(sc.nextInt());
				sc.nextLine();
				sevilla.setCapitan(jugador);
			}else {
				System.out.println("dime el nombre del siguiente jugador");
				jugador.setNombre(sc.nextLine());
				System.out.println("Dime el dorsal del siguiente jugador");
				jugador.setDorsal(sc.nextInt());
				sc.nextLine();
				sevilla.setJugadores(jugador);
			}
			
		}
		Resultado resultadoDerbi = new Resultado();
		Partido derbi = new Partido();
		derbi.setEquipoLocal(betis);
		derbi.setEquipoVisitante(sevilla);
		derbi.setResultado(resultadoDerbi);
		
		System.out.println("Dime los goles del "+derbi.getEquipoLocal().getNombre());
		derbi.getResultado().setGolesLocales(sc.nextInt());
		System.out.println("Dime los goles del "+derbi.getEquipoVisitante().getNombre());
		derbi.getResultado().setGolesVisitante(sc.nextInt());
		sc.nextLine();
		System.out.println(derbi.getEquipoGanador());
		Jugador jugador = new Jugador("Blas infiltrado",99);
		derbi.getEquipoVisitante().setJugadores(jugador);
		System.out.println(derbi.getEquipoVisitante());
		derbi.getEquipoLocal().setCapitan(derbi.getEquipoLocal().getJugadores().get(derbi.getEquipoLocal().getJugadores().size()-1));
		System.out.println(derbi.getEquipoLocal());
	}

}
