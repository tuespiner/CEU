	package Ejercicio_27;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Curso curso_1a = new Curso(1, "DAM-DAW");
		Alumno alumno1 = new Alumno("12345678H",curso_1a);
		Alumno alumno2 = new Alumno(curso_1a);
		Alumno alumno3 = new Alumno("123456h",curso_1a);
		Alumno arrayAlumno[] = new Alumno[3];
		arrayAlumno[0] = alumno1;
		arrayAlumno[1] = alumno2;
		arrayAlumno[2] = alumno3;
		
		for(Alumno alumno : arrayAlumno) {
			if (Alumno.validarDni(alumno.getDni())==false) {
				while(true) {
					System.out.println("El dni no es valido, porfavor ingrese uno valido");
					alumno.setDni(sc.nextLine());
					if(Alumno.validarDni(alumno.getDni())==true) {
						break;
					}
				}
			}
			System.out.println("El dni es valido");
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
