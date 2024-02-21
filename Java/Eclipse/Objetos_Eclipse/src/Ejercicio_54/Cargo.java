package Ejercicio_54;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Cargo extends Movimientos{
	private String cif;
	
	public Cargo(String cif, BigDecimal importe) {
		super(importe);
		this.cif = cif;
	}
	
	public Cargo(String cif) {
		super();
		this.cif = cif;
	}
	
	public Cargo() {
		super();
		this.cif = "";
	}
	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,##0.00 €");
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "[C - " + getFecha().format(fecha) + " - " + formato.format(getImporte().setScale(2,RoundingMode.HALF_DOWN)) + " - " + cif +"]";
	}

}
