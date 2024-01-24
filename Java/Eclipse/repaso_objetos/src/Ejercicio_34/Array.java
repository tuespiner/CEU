package Ejercicio_34;

public class Array {
	private static String[] array;
	
	public Array(Integer longArray) {
		this.array= new String[longArray];
	}
	
	public void addArray(String cadena){
		for(int i = 0; i<this.array.length; i++) {
			if(this.array[i] == null) {
				this.array[i]= cadena;
			}
		}
	}

	public static String[] getArray() {
		return array;
	}

	public static void setArray(String[] array) {
		Array.array = array;
	}
	
	public String toString() {
		
	}
}
