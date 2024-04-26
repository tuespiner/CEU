package Ejercicio_10.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Ejercicio_10.Modelo.Persona;
import Ejercicio_10.Servicios.PersonaService;

public class App {
	private static Scanner sc = new Scanner(System.in);
	private static PersonaService ps = new PersonaService();
	public static void main(String[] args) throws SQLException {
		LocalDate fecha = LocalDate.of(2000, 9, 4);
		String cadNombreApellido = "Hola2";
		List<Persona> lista = new ArrayList<>();
		System.out.println(ps.consultarPersona(cadNombreApellido));
		Persona p = new Persona();
		p.setNombre(cadNombreApellido);
		p.setApellidos(cadNombreApellido);
		p.setDni(cadNombreApellido);
		p.setFechaNacimiento(fecha);
		ps.añadirPersona(p);
		ps.borrarPersonaB();
		ps.consultarPersona(cadNombreApellido);
		sc.close();
	}
	

}

/*for(int i = 0;i<3;i++) {
			Persona p = new Persona();
			p.setNombre(cadNombreApellido);
			p.setApellidos(cadNombreApellido);
			p.setDni(cadNombreApellido);
			p.setFechaNacimiento(fecha);
			System.out.println(p);
			lista.add(p);
			cadNombreApellido = cadNombreApellido + cadNombreApellido;
		}
		ps.insertarPersonas(lista);*/