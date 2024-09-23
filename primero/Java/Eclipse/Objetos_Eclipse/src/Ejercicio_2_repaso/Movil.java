package Ejercicio_2_repaso;

import java.math.BigDecimal;

public class Movil extends Telefono{
	private String gps;
	
	public Movil(Integer numero, String gps) {
		super(numero);
		this.gps = gps;
	}

}
