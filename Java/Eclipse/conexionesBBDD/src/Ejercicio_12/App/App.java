package Ejercicio_12.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Ejercicio_12.Modelo.Persona;
import Ejercicio_12.Servicios.PersonaService;

public class App {
	private static Scanner sc = new Scanner(System.in);
	private static PersonaService ps = new PersonaService();
	public static void main(String[] args) throws SQLException {
		
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