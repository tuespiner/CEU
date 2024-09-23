package Ejercicio_54;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		String iban = "12345678901234567890";
		CuentaAhorros miCuenta = new CuentaAhorros(iban);
		
		BigDecimal decimal =   new BigDecimal(10.0);
		Cargo cargo1 = new Cargo("123456789H",decimal);
		Cargo cargo2 = new Cargo("123456789H",decimal);
		miCuenta.añadirMovimiento(cargo1);
		miCuenta.añadirMovimiento(cargo2);
		
		Ingreso ingreso1 = new Ingreso("eri gay", decimal);
		Ingreso ingreso2 = new Ingreso("eri gay", decimal);
		miCuenta.añadirMovimiento(ingreso1);
		miCuenta.añadirMovimiento(ingreso2);
		
		Retirada retirada1 = new Retirada(decimal);
		miCuenta.añadirMovimiento(retirada1);
		
		System.out.println(miCuenta.getTotal());
		
		for(String movimiento : miCuenta.getMovimientos()) {
			System.out.println(movimiento);
		}
		
		for(String cargo : miCuenta.getCargos()) {
			System.out.println(cargo);
		}
		for(String retirada : miCuenta.getRetiradas()) {
			System.out.println(retirada);
		}
		for(String ingreso : miCuenta.getIngresos()) {
			System.out.println(ingreso);
		}
		
	}

}
