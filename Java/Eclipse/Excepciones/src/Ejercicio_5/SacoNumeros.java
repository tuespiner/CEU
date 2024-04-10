package Ejercicio_5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class SacoNumeros {
	private List<Integer> lista;

	public SacoNumeros() {
		this.lista = new ArrayList<>();
	}

	public void addNumero(Integer numero) {
		this.lista.add(numero);
	}

	public Integer getNumero(Integer posicion) {
		try {
			return this.lista.get(posicion);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La posicion indicada no existe, las posiciones son de 0 a " + this.lista.size());
			return null;
		} catch (NullPointerException a) {
			System.out.println("La posicion no puede ser null");
			return null;
		}
	}

	public BigDecimal division() {
		BigDecimal division = BigDecimal.ONE;
		int contador = 0;
		for (Integer numero : this.lista) {
			if (contador == 0) {
				division = new BigDecimal(this.lista.get(0));
			} else {
				try {
					division = division.divide(new BigDecimal(numero));
				} catch (ArithmeticException e) {
					System.out.println("Algunos elementos de la lista tienen valor 0");
					division = division;	
				}
			}
			contador++;
		}
		return division;
	}

	@Override
	public String toString() {
		return "Lista: " + this.lista.toString();
	}

}
