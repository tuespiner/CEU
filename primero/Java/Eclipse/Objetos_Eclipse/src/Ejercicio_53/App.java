package Ejercicio_53;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		Hucha hucha = new Hucha();
		BigDecimal operacionesConDinero = new BigDecimal(100);
		hucha.meterDinero(operacionesConDinero);
		System.out.println(hucha);
		
		operacionesConDinero = new BigDecimal(50.501);
		hucha.meterDinero(operacionesConDinero);
		System.out.println(hucha);
		
		operacionesConDinero = new BigDecimal(20.5);
		BigDecimal sacoDinero = hucha.sacarDinero(operacionesConDinero);
		System.out.println(hucha);
		
		operacionesConDinero = new BigDecimal(200);
		sacoDinero = hucha.sacarDinero(operacionesConDinero);
		System.out.println(hucha);
		
		hucha.meterDinero(sacoDinero);
		System.out.println(hucha);
		
		hucha.meterDinero(hucha.contarDinero());
		System.out.println(hucha);
		
		operacionesConDinero = hucha.romperHucha();
		hucha.meterDinero(operacionesConDinero);
		System.out.println(hucha);
		
	}

}
