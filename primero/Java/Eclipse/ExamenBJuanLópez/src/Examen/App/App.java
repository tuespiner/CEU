package Examen.App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Examen.Modelo.PeliculaNotFoundException;
import Examen.Modelo.Productora;
import Examen.Servicios.PeliculaErrorException;
import Examen.Servicios.PeliculasService;

public class App {
	public static final Scanner sc = new Scanner(System.in); 
	public static final PeliculasService ps = new PeliculasService();
	public static void main(String[] args) {
		LocalDate fechaIni = null;
		LocalDate fechaFin = null;
		DateTimeFormatter formatoFechas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Boolean consultaExitosa = false;
		Productora productoraPrueba = new Productora();
		productoraPrueba.setNombre("Univerblas Picture");
		do {
			try {
				do {
					fechaIni = setFechaIni(fechaIni, formatoFechas);
				}while(fechaIni == null );
				do {
					fechaFin = setFechaFin(fechaFin, fechaIni, formatoFechas);
				}while(fechaFin == null);
				productoraPrueba.setListaPeliculas(ps.consultarPeliculas(fechaIni, fechaFin));
				consultaExitosa = true;
			}catch(PeliculaNotFoundException e) {
				System.out.println(e.getMessage());
			}catch(PeliculaErrorException e) {
				System.out.println(e.getMessage());
			}
		}while(consultaExitosa == false);
		
		System.out.println(productoraPrueba);
		
		sc.close();
	}
	
	public static LocalDate   setFechaIni(LocalDate fechaIni, DateTimeFormatter formato) {
		try {
			System.out.println("Indica la fecha INICIAL desde la que quieres buscar (dd/MM/yyyy)");
			fechaIni = LocalDate.parse(sc.nextLine(), formato);
		}catch(DateTimeParseException e) {
			fechaIni = null;
			System.out.println("La fecha indicada no es la correcta");
		}
		return fechaIni;
	}
	
	public static LocalDate setFechaFin(LocalDate fechaFin, LocalDate fechaIni, DateTimeFormatter formato) {
		try {
			System.out.println("Indica la fecha FINAL hasta la que quieras buscar (dd/MM/yyyy)");
			fechaFin = LocalDate.parse(sc.nextLine(), formato); 
			if(fechaFin.compareTo(fechaIni) < 0) {
				System.out.println("La fecha final tiene que ser mayor a la inicial");
				fechaFin = null;
			}
		}catch(DateTimeParseException e) {
			fechaFin = null;
			System.out.println("La fecha indicada no es la correcta");
		}
		
		return fechaFin;
	}
}
