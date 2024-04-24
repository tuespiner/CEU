package Prueba.App.copy;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import Prueba.Modelo.Persona;
import Prueba.Servicios.PersonaService;

public class App {

	public static void main(String[] args) throws SQLException {
	
		LocalDate fechaAñadir = LocalDate.of(1983,5,26);
		Scanner sc = new Scanner(System.in);
		PersonaService conexionBBDD = new PersonaService();
		Persona personaAñadir = new Persona();
		Set<Persona> set = null;
		try {
			personaAñadir.setDni("5");
			personaAñadir.setApellidos("Sánchez");
			personaAñadir.setNombre("Juan Gabriel");
			personaAñadir.setFechaNacimiento(fechaAñadir);
			
			//conexionBBDD.añadirPersona(personaAñadir);
			
			Persona p = conexionBBDD.consultarPersona("1");
			System.out.println(p);
			
			p = conexionBBDD.consultarPersona("3");
			System.out.println(p);
			
			set = conexionBBDD.filtro("Juan");
			Iterator<Persona> it = set.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		

	}

}
