package Ejercicio_51;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<BigDecimal> listaDecimales = new ArrayList<>();

		do {	
			System.out.println("Dime un numero");
			BigDecimal decimal = sc.nextBigDecimal();
			if(listaDecimales.isEmpty()) {
				listaDecimales.add(decimal);
			}else if (decimal.max(listaDecimales.get(listaDecimales.size()-1)).equals(decimal)) {
				listaDecimales.add(decimal);
			}else {
				System.out.println("El numero introducido es menor que el anterior numero introducido");
			}
		}while(listaDecimales.size() < 5);
		
		Iterator<BigDecimal> it = listaDecimales.iterator();
		BigDecimal suma = new BigDecimal(0);
		while(it.hasNext()) {
			 suma = suma.add(it.next());
		}
		suma = suma.setScale(1, RoundingMode.HALF_DOWN);
		
		BigDecimal division = listaDecimales.get(0).divide(listaDecimales.get(1)).setScale(3, RoundingMode.HALF_UP);
		
		
		
		sc.close();
		
	}

}
