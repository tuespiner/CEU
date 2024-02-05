package Ejercicio_45;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate actual = LocalDate.now();
		int añoNacimiento = 0;
		int mesNacimiento = 0;
		int diaNacimiento = 0;
		
		while(true) {
			System.out.println("Dime el año en que naciste");
			añoNacimiento = sc.nextInt();
			System.out.println("Dime el mes en que naciste");
			mesNacimiento = sc.nextInt();
			System.out.println("Dime el dia en que nacieste");
			diaNacimiento = sc.nextInt();
			if(añoNacimiento > 1899 && añoNacimiento < 2025) {
				if(mesNacimiento > 0 && mesNacimiento < 13) {
					if(diaNacimiento > 0 && diaNacimiento < 32) {
						break;
					}else {
						System.out.println("El dia esta mal, repitelo");
					}
				}else {
					System.out.println("El mes esta mal, repitelo");
				}
			}else {
				System.out.println("El año esta mal, repitelo");
			}
		}
		
		LocalDate fechaNacimiento = LocalDate.of(añoNacimiento,mesNacimiento,diaNacimiento);
		
		if(fechaNacimiento.isLeapYear()) {
			System.out.println("Es un año bisiesto");
		}else {
			System.out.println("No es un año bisiesto");
		}
		
		System.out.println(fechaNacimiento.getDayOfWeek());
		
		Period edad = fechaNacimiento.until(actual);
		System.out.println("tienes " + edad.getYears()+ " años");
		
		Period periodo = actual.until(fechaNacimiento.plusYears(100));
		
		
		System.out.println("Te quedan "+periodo.getDays()+ "/"+periodo.getMonths() + "/" + periodo.getYears() + " años de esperanza de vida");
		
		
	}

}
