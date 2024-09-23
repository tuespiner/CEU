package Ejercicio_7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Sociedad {
	private Set<Persona> poblacion;

	public Sociedad() {
		this.poblacion = new HashSet<>();
	}

	public void addPersona(String genero, BigDecimal altura) throws ParametroIntroducidoIncorrectoException {
		Persona persona = new Persona();
		try {
			persona.setAltura(altura);
			persona.setGenero(genero);
			poblacion.add(persona);
		}catch(ParametroIntroducidoIncorrectoException e) {
			throw new ParametroIntroducidoIncorrectoException(e.getMessage());
		}
		
	}

	public BigDecimal calcularAlturaMediaHombres() throws ParametroIntroducidoIncorrectoException {
		String cad = "H";
		return filtro(cad);
	}

	public BigDecimal calcularAlturaMediaMujeres() throws ParametroIntroducidoIncorrectoException {
		String cad = "M";
		return filtro(cad);
	}

	public BigDecimal calcularAlturaMedia() throws ParametroIntroducidoIncorrectoException {
		String cad = null;
		return filtro(cad);
	}
	
	public BigDecimal filtro(String genero) throws ParametroIntroducidoIncorrectoException {
		if(genero == null) {
			BigDecimal sumaAlturas = BigDecimal.ZERO;
			int i = 0;
			for (Persona persona : this.poblacion) {
				i++;
				sumaAlturas = sumaAlturas.add(persona.getAltura());
			}
			return sumaAlturas.divide(new BigDecimal(i)).setScale(2, RoundingMode.HALF_EVEN);
		}else if(genero.equalsIgnoreCase("H") || genero.equalsIgnoreCase("M")) {
			BigDecimal sumaAlturas = BigDecimal.ZERO;
			int i = 0;
			for (Persona persona : this.poblacion) {
				if (persona.getGenero().equalsIgnoreCase(genero)) {
					i++;
					sumaAlturas = sumaAlturas.add(persona.getAltura());
				}
			}
			return sumaAlturas.divide(new BigDecimal(i)).setScale(2, RoundingMode.HALF_EVEN);
		}else {
			throw new ParametroIntroducidoIncorrectoException("El genero no es valido");
		}
	}

}
