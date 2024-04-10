package Prueba.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import Prueba.Modelo.Persona;
import Prueba.Servicios.PersonaService;

public class App {

	public static void main(String[] args) throws SQLException {
	
		LocalDate fechaAñadir = LocalDate.of(2005,9,4);
		Scanner sc = new Scanner(System.in);
		PersonaService conexionBBDD = new PersonaService();
		Persona personaAñadir = new Persona();
		personaAñadir.setDni("3");
		personaAñadir.setApellidos("López Carmona");
		personaAñadir.setNombre("Juan");
		personaAñadir.setFechaNacimiento(fechaAñadir);
		
		conexionBBDD.añadirPersona(personaAñadir);
		
		Persona p = conexionBBDD.consultarPersona("1");
		System.out.println(p);
		
		p = conexionBBDD.consultarPersona("3");
		System.out.println(p);
		

	}

}
