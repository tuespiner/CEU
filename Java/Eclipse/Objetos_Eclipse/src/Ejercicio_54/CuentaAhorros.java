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
	
	public CuentaAhorros(String ibn) {
		this.iban = ibn;
		this.listaOperaciones = new ArrayList<>();
	}
	
	public void añadirMovimiento(Movimientos operacion) {
		this.listaOperaciones.add(operacion.toString());
	}
	
	public String getTotal() {
		BigDecimal total= BigDecimal.ZERO;
		DecimalFormat formato = new DecimalFormat("#,##0.00");
		Iterator it = listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().toString().startsWith("[R")) {
				Retirada retirada = new Retirada();
				total = total.subtract(it.next());
			}
		}
		return formato.format(total.setScale(2, RoundingMode.HALF_DOWN));
	}
	
	public List<String> getMovimientos(){
		return this.listaOperaciones;
	}
	public List<String> getRetiradas() {
		List<String> retiradas= new ArrayList<>();
		Iterator<String> it = this.listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().startsWith("[R")) {
				retiradas.add(it.next());
			}
		}
		return retiradas;
	}
	
	public List<String> getIngresos() {
		List<String> retiradas= new ArrayList<>();
		Iterator<String> it = this.listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().startsWith("[I")) {
				retiradas.add(it.next());
			}
		}
		return retiradas;
	}
	
	public List<String> getCargos() {
		List<String> retiradas= new ArrayList<>();
		Iterator<String> it = this.listaOperaciones.iterator();
		while(it.hasNext()) {
			if(it.next().startsWith("[C")) {
				retiradas.add(it.next());
			}
		}
		return retiradas;
	}
	

}
