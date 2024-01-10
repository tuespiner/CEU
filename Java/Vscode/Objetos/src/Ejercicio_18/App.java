package Ejercicio_18;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		Alumno alumno1 = new Alumno();
		//alumno1.Dni= "12345678H";
		System.out.println("Dime tu Dni");
		alumno1.setDni(scanner.nextLine());
		System.out.println("Dime tu Nombre");
		alumno1.setNombre(scanner.nextLine());
		System.out.println("Dime tu Edad");
		alumno1.setEdad(scanner.nextInt());
		System.out.println("Dime tu nota");
		alumno1.setNota(scanner.nextDouble());
		System.out.println("DNI: "+alumno1.getDni()+" Nombre: "+alumno1.getNombre()+" Edad: "+alumno1.getEdad()+" Nota "+ alumno1.getNota());
		
		
	}

}
