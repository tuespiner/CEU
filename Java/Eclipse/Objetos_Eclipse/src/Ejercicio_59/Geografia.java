package Ejercicio_59;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Geografia {
	private Map<String, String> paises;

	public Geografia() {
		this.paises = new HashMap<>();
	}

	public Boolean agregarPais(String nombre, String capital) {
		nombre = nombre.toUpperCase();
		capital = capital.substring(0, 1).toUpperCase() + capital.substring(1, capital.length());
		if (this.paises.containsKey(nombre.toUpperCase())) {
			this.paises.put(nombre, capital);
			return true;
		} else {
			this.paises.put(nombre, capital);
			return false;
		}
	}

	public String obtenerCapital(String nombre) {
		nombre = nombre.toUpperCase();
		if (this.paises.containsKey(nombre)) {
			return this.paises.get(nombre);
		} else {
			return "";
		}
	}

	public void imprimirPaises() {
		for (String key : this.paises.keySet()) {
			System.out.println("PAIS: " + key + " - CAPITAL: " + this.paises.get(key));
		}
	}

	public void eliminarPais(String pais) {
		pais = pais.toUpperCase();
		if (this.paises.containsKey(pais)) {
			this.paises.remove(pais);
		}
	}

	public BigDecimal calcularLongitudMediaPaises() {
		if (!this.paises.isEmpty()) {
			BigDecimal resultado = BigDecimal.ZERO;
			Integer sumaCaracteres = 0;
			for (String pais : this.paises.keySet()) {
				sumaCaracteres += pais.length();
			}
			resultado = new BigDecimal(sumaCaracteres / this.paises.size());
			return resultado;
		} else {
			return BigDecimal.ZERO;
		}

	}

	public void eliminarPaisConCapitalLetra(String letra) {
		Iterator it = this.paises.keySet().iterator();
		while (it.hasNext()) {
			String primeraLetraIt = this.paises.get(it.next()).substring(0, 1);
			if (primeraLetraIt.equals(letra)) {
				it.remove();
				break;
			}
		}

	}
	
	public Integer numeroPaisesConCapitalLetra(String letra) {
		Integer numero = 0;
		for(String key : this.paises.keySet()) {
			String ini = this.paises.get(key);
			if(ini.equals(letra)) {
				numero++;
			}
		}
		
		return numero;
	}
	
	public void imprimirNumeroPaisesLetra(String letra) {
		int contador = 0;
		for(String key : this.paises.keySet()) {
			String ini = this.paises.get(key).substring(0,1);
			if(ini.equals(letra)) {
				contador++;
				System.out.println("Pais: "+key+", Capital: "+this.paises.get(key));
			}
		}
		
		if(contador == 0) {
			System.out.println("Ninguna capital del mapa comienza por la letra "+letra);
		}
	}
	
	public void mismaLetra() {
		int contador = 0;
		for(String key : this.paises.keySet()) {
			String iniPais = key.substring(0,1);
			String iniCapital = this.paises.get(key).substring(0,1);
			if(iniPais.equals(iniCapital)) {
				contador++;
				System.out.println("Pais: "+key+", Capital: "+this.paises.get(key));
			}
			
			if(contador == 0) {
				System.out.println("No hay ningun pais y capital que comiencen por la misma letra");
			}
		}
	}
}
