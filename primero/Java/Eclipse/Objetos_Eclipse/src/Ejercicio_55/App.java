package Ejercicio_55;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Evaluacion evaluacion1 = new Evaluacion();
		evaluacion1.addNota("11111111a", new BigDecimal(5.5));
		evaluacion1.addNota("11111112a", new BigDecimal(4));
		evaluacion1.addNota("11111113a", new BigDecimal(9.5));
		evaluacion1.addNota("11111114a", new BigDecimal(8.2));
		evaluacion1.addNota("11111115a", new BigDecimal(2.1));
		
		System.out.println(evaluacion1);
		
		evaluacion1.addNota("11111115a", new BigDecimal(4.1));
		
		System.out.println(evaluacion1);
		
		System.out.println(evaluacion1.corregirNota("11111115a", new BigDecimal(5.1)));
		System.out.println(evaluacion1.corregirNota("11111116a", new BigDecimal(10)));
		
		System.out.println(evaluacion1);
		
		System.out.println(evaluacion1.obtenerNotaAlumno("11111111a"));
		System.out.println(evaluacion1.obtenerNotaMedia());
		
		System.out.println(evaluacion1.obtenerCantidadAprobados());
		
		DecimalFormat formato = new DecimalFormat("0.0");
		System.out.println("Lista suspensos:");
		for(BigDecimal suspensos : evaluacion1.obtenerSuspensos()) {
			System.out.println("\t"+formato.format(suspensos)+"\n");
		}
		
		evaluacion1.borrarAprobados();
		System.out.println(evaluacion1);
	}

}
