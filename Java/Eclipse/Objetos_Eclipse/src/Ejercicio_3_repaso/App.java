package Ejercicio_3_repaso;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		BigDecimal latitud = new BigDecimal(40.7127837);
		BigDecimal longitud = new BigDecimal(-74.0059413);
		
		LocalizacionGPS gps1 = new LocalizacionGPS(latitud, longitud);
		Movil movil1 = new Movil(654654654, gps1);
		Fijo fijo1 = new Fijo(954954954, "C/ mi casa nº13");
		
		System.out.println(movil1.consultarNumero());
		System.out.println(fijo1.consultarNumero());
		
		movil1.marcar(654654654);
		movil1.marcar(610610610);
		movil1.colgar();
		movil1.colgar();
		
	}

}
