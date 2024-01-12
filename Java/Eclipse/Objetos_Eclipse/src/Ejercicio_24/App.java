package Ejercicio_24;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Curso curso_1a = new Curso(1, "DAM-DAW");
		Alumno alumno1 = new Alumno(curso_1a);
		Alumno alumno2 = new Alumno(curso_1a);
		Alumno alumno3 = new Alumno(curso_1a);
		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
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
			}
		}
		
		
	}


