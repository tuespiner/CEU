package App;

import java.time.LocalDate;
import java.util.Scanner;

import Modelo.Equipo;
import Modelo.Jugador;

public class App {
	public static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Integer respuesta = -1;
		do {
			respuesta = menuPrincipal();
			switch(respuesta) {
				case 1:
					System.out.println("Listado de equipos:");
					break;
				case 2:
					opcion2();
					break;
				case 3:
					opcion3();
					break;
			}
		}while(respuesta != 0);
		System.out.println("Bye!");
		sc.close();
	}

	public static Integer  menuPrincipal(){
		Integer respuesta = -1;
		do {
			System.out.println("--------------------------------------------------\n"+
					   "Elige una de estas opciones:\n\t"+
					   "(1) Ver todos los equipos registrados\n\t"+
					   "(2) Crear nuevo equipo\n\t"+
					   "(3) Consultar un equipo por su código\n\t"+
					   "(0) Salir\n"+
					   "--------------------------------------------------");
			respuesta = sc.nextInt();sc.nextLine();
		}while(respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 0);
		return respuesta;
	}
	
	public static void opcion2() {
		Equipo equipo = new Equipo();
		System.out.println("Dime el código del equipo");
		equipo.setCodigo(sc.nextLine());
		System.out.println("Dime el nombre del equipo");
		equipo.setNombre(sc.nextLine());
		String continuar = "s";
		do {
			equipo.getJugadores().add(crearJugador(equipo));
			System.out.println("¿Desea aádir otro jugador? (S/N)");
			continuar = sc.nextLine();
		}while(continuar.equalsIgnoreCase("n"));
		System.out.println("Equipo guardado!!");
	}
	
	public static Jugador crearJugador(Equipo equipo) {
		Jugador jugador = new Jugador();
		jugador.setCodigoEquipo(equipo.getCodigo());
		System.out.println("Dime el numero del jugador");
		jugador.setNumero(sc.nextInt());sc.nextLine();
		System.out.println("Dime el nombre del jugador");
		jugador.setNombre(sc.nextLine());
		System.out.println("Dime la fecha de nacimiento del jugador en este orden poco a poco yy mm dd");
		jugador.setNacimiento(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		sc.nextLine();
		return jugador;
	}
	public static void opcion3() {
		System.out.println("--------------------------------------------------"+
						   "\n\t(1) Ver plantilla del equipo" +
						   "\n\t(2) Borrar equipo" +
						   "\n\t(3) Añadir un equipo" +
						   "\n\t(4) Calcular edad media de plantilla" +
						   "\n\t(5) Exportar plantilla del equipo a fichero" +
						   "\n\t(0) volver al menú principal" +
						   "--------------------------------------------------");
	}
}
