package Ejercicio_30;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumno alumno1 = new Alumno();
		Curso curso1 = new Curso(1,"DAW-DAM");
		
		if(Alumno.validar(alumno1) == true) {
			System.out.println("DNI: "+alumno1.getDni()+"\nNombre: "+alumno1.getNombre()+"\n"+curso1.toString()+"\nEdad: "+alumno1.getEdad());
		}else {
			System.out.println("No tenemos todos los datos");
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
