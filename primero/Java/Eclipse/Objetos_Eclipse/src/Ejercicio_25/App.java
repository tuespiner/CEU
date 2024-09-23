package Ejercicio_25;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Curso curso_1a = new Curso(1, "DAM-DAW");
		Alumno alumno1 = new Alumno(curso_1a);
		Alumno alumno2 = new Alumno(curso_1a);
		Alumno alumno3 = new Alumno(curso_1a);
		Alumno arrayAlumno[] = new Alumno[3];
		arrayAlumno[0] = alumno1;
		arrayAlumno[1] = alumno2;
		arrayAlumno[2] = alumno3;
		int i = 0;

		for (Alumno alumno : arrayAlumno) {
			i++;
			System.out.println("Dime el nombre del alumno" + i);
			alumno.setNombre(sc.nextLine());
			System.out.println("Dime el dni del alumno" + i);
			alumno.setDni(sc.nextLine());
			System.out.println("Dime la edad del alumno" + i);
			alumno.setEdad(sc.nextInt());
			System.out.println("Dime la nota del alumno" + i);
			alumno.setNota(sc.nextDouble());
			sc.nextLine();
		}
		if (repetidos(arrayAlumno) == true) {
			System.out.println("Error: Hay alumnos repetidos");
		} else {
			System.out.println("Todos los alumnos ingresados");
		}
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
