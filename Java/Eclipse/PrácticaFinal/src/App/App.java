package App;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Modelo.Equipo;
import Modelo.Jugador;
import Servicio.EquipoServiceException;
import Servicio.EquiposService;
import Servicio.NotFoundException;

public class App {
	public static final Scanner sc = new Scanner(System.in);
	public static final EquiposService es = new EquiposService();
	public static void main(String[] args) {
		Integer respuesta = -1;
		Jugador j = new Jugador();
		j.setNacimiento(LocalDate.of(2005, 9, 4));
		j.getEdad();
		do {
			try {
				respuesta = menuPrincipal();
				switch(respuesta) {
					case 0:
						break;
					case 1:
						opcion1();
						break;
					case 2:
						opcion2();
						break;
					case 3:
						System.out.println("Indica Código equipo:");
						opcion3(sc.nextLine());
						break;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
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
	public static void opcion1() {
		try {
			List<Equipo> listaEquipos = es.consultarEquipos();
			if(listaEquipos.isEmpty()) {
				System.out.println("No hay equipos en la bbdd");
			}else {
				System.out.println("Listado de equipos:");
				for(Equipo e : listaEquipos) {
					System.out.println("\tEquipo: "+e.getCodigo()+" / "+e.getNombre());
				}
			}
		}catch(EquipoServiceException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void opcion2() throws EquipoServiceException {
		Equipo equipo = new Equipo();
		System.out.println("Dime el código del equipo");
		equipo.setCodigo(sc.nextLine());
		System.out.println("Dime el nombre del equipo");
		equipo.setNombre(sc.nextLine());
		String continuar = "s";
		do {
			equipo.getJugadores().add(crearJugador(equipo));
			System.out.println("¿Desea añadir otro jugador? (S/N)");
			continuar = sc.nextLine();
		}while(!continuar.equalsIgnoreCase("n"));
		es.crearEquipo(equipo);
		System.out.println("Equipo guardado!!");
	}
	
	public static Jugador crearJugador(Equipo equipo) {
		Jugador jugador = new Jugador();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy");
		jugador.setCodigoEquipo(equipo.getCodigo());
		System.out.println("Dime el nombre del jugador");
		jugador.setNombre(sc.nextLine());
		System.out.println("Dime la fecha de nacimiento del jugador en este orden poco a poco yy mm dd");
		jugador.setNacimiento(LocalDate.parse(sc.nextLine(), formato));
		return jugador;
	}
	public static void opcion3(String codigoEquipo) throws NotFoundException, EquipoServiceException, IOException, SQLException {
		mostrarEquipo(codigoEquipo);
		Integer respuesta = 1;
		do {
			Equipo equipo = es.consultarEquipoCompleto(codigoEquipo);
			System.out.println("--------------------------------------------------"+
					   "\n\t(1) Ver plantilla del equipo" +
					   "\n\t(2) Borrar equipo" +
					   "\n\t(3) Añadir un jugador" +
					   "\n\t(4) Calcular edad media de plantilla" +
					   "\n\t(5) Exportar plantilla del equipo a fichero" +
					   "\n\t(0) volver al menú principal" +
					   "\n--------------------------------------------------");
			respuesta = sc.nextInt();sc.nextLine();
			switch(respuesta){
				case 1:
					mostrarEquipo(codigoEquipo);
					break;
				case 2:
					es.borrarEquipoCompleto(codigoEquipo);
					System.out.println("Equipo eliminado !!");
					break;
				case 3:
					es.añadirJugadorAEquipo(equipo, crearJugador(equipo));
					System.out.println("Jugador guardado!!");
					break;
				case 4:
					edadMedia(codigoEquipo);
					break;
				case 5:
					System.out.println("Indica Ruta fichero:");
					es.exportarJugadores(codigoEquipo, sc.nextLine());
					System.out.println("Fichero generado!!");
					break;
				case 0:
					break;
			}
		}while(respuesta != 0);
	}
	public static void mostrarEquipo(String codigoEquipo) throws NotFoundException, EquipoServiceException {
		Equipo e = es.consultarEquipoCompleto(codigoEquipo);
		System.out.println(e);
	}
	public static void edadMedia(String codigoEquipo) throws NotFoundException, EquipoServiceException {
		Equipo e = es.consultarEquipoCompleto(codigoEquipo);
		BigDecimal edadTotal = BigDecimal.ZERO;
		int i = 0;
		for(Jugador j: e.getJugadores()) {
			i++;
			edadTotal = edadTotal.add(j.getEdad());
		}
		edadTotal = edadTotal.divide(new BigDecimal(i)).setScale(2, RoundingMode.HALF_DOWN);
		System.out.println("Edad media: "+ edadTotal.toString());
		
	}
}
