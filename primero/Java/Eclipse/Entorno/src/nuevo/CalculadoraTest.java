package nuevo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {
	Calculadora cal;

	@Test
	public void restaSobreValor() {
		cal.resta(1);
		cal.resta(2);
	}
}
