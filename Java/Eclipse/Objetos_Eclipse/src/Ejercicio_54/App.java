package Ejercicio_54;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		String iban = "12345678901234567890";
		CuentaAhorros miCuenta = new CuentaAhorros(iban);
		
		BigDecimal decimal =   new BigDecimal(10.0);
		Cargo cargo1 = new Cargo("123456789H",decimal);
		Cargo cargo2 = new Cargo("123456789H",decimal);
		
		Ingreso ingreso1 = new Ingreso("eri gay", decimal);
		Ingreso ingreso2 = new Ingreso("eri gay", decimal);
		
		Retirada retirada1 = new Retirada();
	}

}
