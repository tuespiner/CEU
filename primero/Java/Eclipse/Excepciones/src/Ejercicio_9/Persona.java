package Ejercicio_9;

import java.math.BigDecimal;

public class Persona {
	private String genero;
	private BigDecimal altura;
	
	public Persona() {
		
	}

	public String getGenero() {
		return this.genero;
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
		String cad = "Persona [genero= ";
		if(this.genero.equalsIgnoreCase("H")) {
			cad = cad + "Hombre";
		}else {
			cad = cad + "Mujer";
		}
		cad = cad + ", altura=" + altura + "]";
		
		return cad;
	}
	
	
}
