package nuevo;

public class TablaEnteros {

	private Integer[] tabla;
	
	/** Inicializa la clase con el array de enteros que se le pasa por par�metro */
	public TablaEnteros(Integer[] tabla) {
		this.tabla = tabla;
	}
	
	/** Suma los elementos del array y devuelve el resultado */
	public Integer sumaTabla() {
		Integer suma = 0;
		for (Integer entero : tabla) {
			suma += entero;
		}
		return suma;
	}
	
	/** Encuentra el mayor elemento de la tabla y lo devuelve */
	/** Si el array es vac�o, devolver� null */
	public Integer mayorTabla() {
		Integer maximo = null;
		for (Integer entero : tabla) {
			if (maximo == null || entero > maximo) {
				maximo = entero;
			}
		}
		return maximo;
	}
	
	/** Encuenta el elemento en el array que coincide con el indicado y devuelve su posici�n. */
	/** Si no lo encuentra, devuelve -1 */
	public Integer posicionTabla(Integer valor) {
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
}
