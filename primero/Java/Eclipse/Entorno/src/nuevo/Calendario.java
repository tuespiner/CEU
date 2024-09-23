package nuevo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Calendario {
	private LocalDate date;

	/**
	 * Constructor de la clase que recibe una fecha en formato dd/MM/yyyy	  
	 * @param fecha (cadena en formato dd/MM/yyyy)
	 */
	public Calendario(String fecha) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			date = LocalDate.parse(fecha, formato);
		} catch (DateTimeParseException e) {
			date = LocalDate.now();
		}
	}

	/** Devuelve el n�mero de d�a del mes de la fecha cargada en el calendario */
	/** Por ejemplo, para el 13/02/2021, devuelve 13 */
	public Integer getDia() {
		return date.getDayOfMonth();
	}

	/** Devuelve el n�mero del mes del a�o de la fecha cargada en el calendario */
	/** Por ejemplo, para el 13/02/2021, devuelve 2 */
	public Integer getMes() {
		return date.getMonthValue();
	}

	/** Devuelve el a�o de la fecha cargada en el calendario. */
	/** Por ejemplo, para el 13/02/2021, devuelve 2021 */
	public Integer getAño() {
		return date.getYear();
	}

	/**
	 * Devuelve el n�mero de d�as que tiene el mes de la fecha cargada en el
	 * calendario. Por ejemplo, para el 13/02/2021, devuelve 28 */
	public Integer getNumeroDiasMes() {
		switch (getMes()) {
		case 1: case 3: case 5:	case 7:	case 8:	case 10: case 12:
			return 31;
		case 4: case 6:	case 9:	case 11:
			return 30;
		case 2:
			if (isBisiesto()) {
				return 29;
			}
			return 28;
		default:
			return 0;
		}
	}

	/**
	 * Devuelve true si, y solo si, el a�o de la fecha cargada en el calendario es bisiesto.  
	 * Por ejemplo, para el 13/02/2021, devuelve false */
	public Boolean isBisiesto() {
		Integer año = getAño();
		return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
	}
}

