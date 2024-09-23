package Ejercicio_53;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Hucha {
	private BigDecimal ahorros;

	public Hucha() {
		this.ahorros = BigDecimal.ZERO.setScale(2,RoundingMode.HALF_EVEN);
	}
	
	public void meterDinero(BigDecimal ingreso) {
		this.ahorros = ahorros.add(ingreso);
		
		
	}
	
	public BigDecimal sacarDinero(BigDecimal retirada) {
		BigDecimal total =this.ahorros;
		if(this.ahorros.max(retirada) != this.ahorros) {
			this.ahorros = BigDecimal.ZERO;
			return total;
		}else {
			this.ahorros = total.subtract(retirada);
			return retirada;
		}
		
	}
	
	public BigDecimal contarDinero() {
		return this.ahorros;
	}
	
	public BigDecimal romperHucha() {
		BigDecimal total =this.ahorros;
		this.ahorros = BigDecimal.ZERO;
		return total;
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,##0.00€");
		return "Hucha [ahorros = " + formato.format(this.ahorros) + " ]";
	}
	
	
	
}
