package Ejercicio_54;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Movimientos {
	private LocalDate fecha;
	private BigDecimal importe;
	
	public Movimientos() {
		this.importe = BigDecimal.ZERO;
		this.fecha = LocalDate.now();
	}
	
	public Movimientos(BigDecimal importe) {
		this.importe = importe;
		this.fecha = LocalDate.now();
	}
	
	public void setImporte(BigDecimal importe) {
		this.importe= importe;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	
	public abstract String toString();
	
	
	
}
