package Ejercicio_7;

import java.math.BigDecimal;

public class Persona {
	private String genero;
	private BigDecimal altura;
	
	public Persona() {
		
	}

	public String getGenero() {
		if(this.genero.equalsIgnoreCase("H")) {
			return "hombre";
		}else {
			return "Mujer";
		}
	}

	public void setGenero(String genero) throws ParametroIntroducidoIncorrectoException {
		
			if(genero.equalsIgnoreCase("H") || genero.equalsIgnoreCase("M")) {
				this.genero = genero;
			}else {
				this.genero = null;
				throw new ParametroIntroducidoIncorrectoException("Tiene que se o M o H");
			}
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) throws ParametroIntroducidoIncorrectoException{
		if(altura.compareTo(BigDecimal.ZERO) <= 0 || altura.compareTo(new BigDecimal(3)) >=0) {
			this.altura = null;
			throw new ParametroIntroducidoIncorrectoException("No puede ser ni 0 ni menor que 0 ni mayor que 3 ");
		}else {
			this.altura = altura;
		}
		
	}

	@Override
	public String toString() {
		return "Persona [genero=" + genero + ", altura=" + altura + "]";
	}
	
	
}
