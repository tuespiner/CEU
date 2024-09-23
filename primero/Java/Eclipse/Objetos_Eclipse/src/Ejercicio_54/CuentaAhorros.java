package Ejercicio_54;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CuentaAhorros {
	private String iban;
	private List<String> listaOperaciones;
	private BigDecimal total;
	
	public CuentaAhorros(String ibn) {
		this.iban = ibn;
		this.listaOperaciones = new ArrayList<>();
		this.total = BigDecimal.ZERO;
	}
	
	public void añadirMovimiento(Movimientos operacion) {
		this.listaOperaciones.add(operacion.toString());
		if(operacion.toString().startsWith("[C")|| operacion.toString().startsWith("[R")) {
			this.total = total.subtract(operacion.getImporte());
		}else if(operacion.toString().startsWith("[I")) {
			this.total = total.add(operacion.getImporte());
		}
	}
	
	public String getTotal() {
		DecimalFormat formato = new DecimalFormat("#,##0.00");
		if(this.total.doubleValue() < 0) {
			this.total = BigDecimal.ZERO;
			return formato.format(this.total.setScale(2, RoundingMode.HALF_DOWN));
		}else {
			return formato.format(this.total.setScale(2, RoundingMode.HALF_DOWN));
		}
	}
	
	public List<String> getMovimientos(){
		return this.listaOperaciones;
	}
	public List<String> getRetiradas() {
		List<String> retiradas= new ArrayList<>();
		/*Iterator<String> it = this.listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().startsWith("[R")) {
				retiradas.add(it.next());
			}
		}*/
		for(String movimiento : this.listaOperaciones) {
			if(movimiento.startsWith("[R")) {
				retiradas.add(movimiento);
			}
		}
		return retiradas;
	}
	
	public List<String> getIngresos() {
		List<String> retiradas= new ArrayList<>();
		/*Iterator<String> it = this.listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().startsWith("[I")) {
				retiradas.add(it.next());
			}
		}*/
		for(String movimiento : this.listaOperaciones) {
			if(movimiento.startsWith("[I")) {
				retiradas.add(movimiento);
			}
		}
		return retiradas;
	}
	
	public List<String> getCargos() {
		List<String> retiradas= new ArrayList<>();
		/*Iterator<String> it = this.listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().startsWith("[C")) {
				retiradas.add(it.next());
			}
		}*/
		for(String movimiento : this.listaOperaciones) {
			if(movimiento.startsWith("[C")) {
				retiradas.add(movimiento);
			}
		}
		return retiradas;
	}
	

}
