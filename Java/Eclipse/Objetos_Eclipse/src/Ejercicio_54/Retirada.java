package Ejercicio_54;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Retirada extends Movimientos{
	
	public Retirada() {
		super();
	}
	
	public Retirada(BigDecimal importe) {
		super(importe);
	}
	
	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,##0.00 €");
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "[R - " + getFecha().format(fecha) + " - " + formato.format(getImporte().setScale(2,RoundingMode.HALF_DOWN)) +"]";
	}
}
