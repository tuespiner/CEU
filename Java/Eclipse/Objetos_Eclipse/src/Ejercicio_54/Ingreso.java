package Ejercicio_54;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Ingreso extends Movimientos{
	private String descripcion;
	
	public Ingreso(BigDecimal importe) {
		super(importe);
		this.descripcion = "";
	}
	
	public Ingreso(String desc, BigDecimal importe) {
		super(importe);
		this.descripcion = desc;
	}
	
	public Ingreso() {
		super();
		this.descripcion = "";
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,##0.00 €");
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "[I - " + getFecha().format(fecha) + " - " + formato.format(getImporte().setScale(2,RoundingMode.HALF_DOWN)) + " - " + descripcion +"]";
	}

	
	
}
