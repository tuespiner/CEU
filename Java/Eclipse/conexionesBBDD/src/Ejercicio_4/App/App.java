package Ejercicio_4.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import Prueba.Modelo.Persona;
import Prueba.Servicios.PersonaService;

public class App {
	private static Scanner sc = new Scanner(System.in);
	private static PersonaService ps = new PersonaService();
	public static void main(String[] args) throws SQLException {
		try {
			String respuesta = "";
			do {
				respuesta = menu();
				switch(respuesta) {
				case "1":
					System.out.println(consultarPersona());
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				}
				
			}while(!respuesta.equals("4"));
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}
	
	public static String menu() {
		String respuesta = "";
		System.out.println("Elige una opción:\n\t1) Consultar una persona\n\t2) Añadir persona\n\t3) Crear filtro de personas\n\t4) Salir");
		respuesta = sc.nextLine();
		return respuesta;
	}
	
	public static Persona consultarPersona() throws SQLException {
		System.out.println("Dime el DNI de la persona que quieres consultar");
		String dni = sc.nextLine();
		Persona persona = ps.consultarPersona(dni);
		return persona;
	}
	
	public static void añadirPersona() throws SQLException{
		System.out.println("");
	}
	
	public Persona crearPersona() {
		Persona p = new Persona();
		System.out.println("Dime el DNI");
		p.setDni(sc.nextLine());
		System.out.println("Dime el Nombre");
		p.setNombre(sc.nextLine());
		System.out.println("Dime el Apellido");
		p.setApellidos(sc.nextLine());
		System.out.println("Dime la fecha");
		return p;
	}

}
