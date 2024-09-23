package Ejercicio_35;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Curso curso_1a = new Curso(1, "DAM-DAW");
		Alumno alumno1 = new Alumno(curso_1a);
		Alumno alumno2 = new Alumno(curso_1a);
		Alumno alumno3 = new Alumno(curso_1a);
		List<Alumno> listaAlumnos = new ArrayList<>();
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		int i = 0;

		for (Alumno alumno : listaAlumnos) {
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
		if (repetidos(listaAlumnos) == true) {
			System.err.println("Error: Hay alumnos repetidos");
		} else {
			System.out.println("Todos los alumnos ingresados");
		}
	}

	public static Boolean repetidos(List<Alumno> lista) {
		Boolean verdadero = false;
		if (lista.get(0).equals(lista.get(1)) || lista.get(0).equals(lista.get(2))) {
			return verdadero = true;
		} else if (lista.get(1).equals(lista.get(2))) {
			return verdadero = true;
		} else {
			return verdadero;
		}

	}
}
