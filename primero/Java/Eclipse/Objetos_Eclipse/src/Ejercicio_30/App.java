package Ejercicio_30;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumno alumno1 = new Alumno();
		Curso curso1 = new Curso(1, "DAW-DAM", 12);
		
		alumno1.setDni("12345678H");
		alumno1.setNombre("Juan López Carmona");
		alumno1.setCurso(curso1);
		curso1.addAlumno(alumno1);
		System.out.println(curso1.getAlumnos()[0]);
		
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
