package Ejercicio_55;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Evaluacion {
	private Map<String,BigDecimal> evaluacion;
	
	public Evaluacion() {
		this.evaluacion = new HashMap<>();
	}
	
	public Boolean addNota(String dni, BigDecimal nota) {
		if(this.evaluacion.get(dni) == null) {
			this.evaluacion.put(dni,nota);
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean corregirNota(String dni, BigDecimal nota) {
		if(this.evaluacion.get(dni) != null) {
			this.evaluacion.put(dni, nota);
			return true;
		}else {
			return false;
		}
	}
	
	public String obtenerNotaAlumno(String dni) {
		DecimalFormat formato = new DecimalFormat("0.0");
		return formato.format(this.evaluacion.get(dni));
	}
	
	public String obtenerNotaMedia() {
		DecimalFormat formato = new DecimalFormat("0.0");
		BigDecimal media =  BigDecimal.ZERO;
		Set<String> keys = this.evaluacion.keySet();
		for(String key : keys) {
			if(this.evaluacion.get(key)== null) {
				media = media.add(BigDecimal.ZERO);
			}else {
				media = media.add(this.evaluacion.get(key));
			}
			
		}
		
		return formato.format(media.divide(new BigDecimal(this.evaluacion.size())));
	}
	
	public Integer obtenerCantidadAprobados() {
		Integer aprobados = 0;
		Set<String> keys = this.evaluacion.keySet();
		for(String key : keys) {
			if(this.evaluacion.get(key).compareTo(new BigDecimal(5)) >=0 && this.evaluacion.get(key)!=null) {
				aprobados++;
			}
		}
		return aprobados;
	}
	
	public List<BigDecimal> obtenerSuspensos() {
		List<BigDecimal> suspensos = new ArrayList<>();
		Set<String> keys = this.evaluacion.keySet();
		for(String key : keys) {
			if(this.evaluacion.get(key).compareTo(new BigDecimal(5)) <0 && this.evaluacion.get(key)!=null) {
				suspensos.add(this.evaluacion.get(key));
			}
		}
		return suspensos;
	}
	public void borrarAprobados() {
		Iterator<String> it = this.evaluacion.keySet().iterator();
		while(it.hasNext()) {
			if(this.evaluacion.get(it.next()).compareTo(new BigDecimal(5)) >=0 ) {
				it.remove();
				
			}
			
		}
	}
	
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.0");
		String cad = "";
		String aprobados = "Aprobados:\n";
		String suspensos = "Suspensos:\n";
		Set<String> keys = this.evaluacion.keySet();
		for(String key : keys) {
			if(this.evaluacion.get(key).compareTo(new BigDecimal(5)) >=0 ) {
				aprobados = aprobados +"\t" +key+" ("+formato.format(this.evaluacion.get(key))+")\n";
			}else {
				suspensos = suspensos + "\t"+ key+" ("+formato.format(this.evaluacion.get(key))+")\n";
			}
		}
		cad = aprobados + suspensos;
		return cad;
	}
}