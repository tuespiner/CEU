package Ejercicio_29;

import java.util.ArrayList;
import java.util.Scanner;

import Ejercicio_30.Alumno;
import Ejercicio_30.Curso;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumno alumno1 = new Alumno();
		Curso curso1 = new Curso(1,"DAW-DAM");
		
		do {
			if (Alumno.validar(alumno1) == true) {
				System.out.println("DNI: " + alumno1.getDni() + "\nNombre: " + alumno1.getNombre() + "\n"
						+ curso1.toString() + "\nEdad: " + alumno1.getEdad());
			} else {
				Curso curso_validar = new Curso();
				System.err.println("\n\n\n\n\n\n\n\n\n\nNo tenemos todos los datos o son incorrectos");
				System.out.println("Dime el nombre (Mínimo 10 caracteres)");
				alumno1.setNombre(sc.nextLine());
				System.out.println("Dime el DNI (00000000A)");
				alumno1.setDni(sc.nextLine());
				System.out.println("Dime la edad (12-65 años)");
				alumno1.setEdad(sc.nextInt());
				System.out.println("Dime el identificador del curso");
				curso_validar.setIdentificador(sc.nextInt());
				sc.nextLine();
				System.out.println("Dime la descripción del curso");
				curso_validar.setDescripcion(sc.nextLine());
				alumno1.setCurso(curso_validar);
				System.out.println("\n\n\n\n\n\n"+alumno1.toString());
			}
		} while (Alumno.validar(alumno1) == false);

		
		
		}

	

	public static Boolean repetidos(Alumno arrayAlumno[]) {
		Boolean verdadero = false;
		if (arrayAlumno[0].equals(arrayAlumno[1]) || arrayAlumno[0].equals(arrayAlumno[2])) {
			return verdadero = true;
		} else if (arrayAlumno[1].equals(arrayAlumno[2])) {
			return verdadero = true;
		} else {
			return verdadero;
		}

	}
}
