package Ejercicio_3_y_4;

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
		}catch(IndexOutOfBoundsException e) {
			System.out.println("La posicion indicada no existe, las posiciones son de 0 a " + this.lista.size());
			return null;
		}catch(NullPointerException a) {
			System.out.println("La posicion no puede ser null");
			return null;
		}
	}

	@Override
	public String toString() {
		return "Lista: " + this.lista.toString();
	}
	
	
	
	
}
