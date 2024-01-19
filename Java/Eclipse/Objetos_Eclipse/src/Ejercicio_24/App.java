package Ejercicio_24;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Curso curso_1a = new Curso(1, "DAM-DAW");
		Alumno alumnoArray[] = new Alumno[3];
		Alumno alumno1 = new Alumno(curso_1a);
		Alumno alumno2 = new Alumno(curso_1a);
		Alumno alumno3 = new Alumno(curso_1a);
		
		int i = 0;
		
		for(Alumno alumno : alumnos) {
			i++;
			System.out.println("Dime el nombre del alumno"+i);
			alumno.setNombre(sc.nextLine());
			System.out.println("Dime el dni del alumno"+i);
			alumno.setDni(sc.nextLine());
			System.out.println("Dime la edad del alumno"+i);
			alumno.setEdad(sc.nextInt());
			System.out.println("Dime la nota del alumno"+i);
			alumno.setNota(sc.nextDouble()); sc.nextLine();
			}
		
		}
		
		
		
	}


