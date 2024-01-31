package Ejercicio_38;

import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		Pila pila1= new Pila();
		pila1.añadirCadena("primero");
		pila1.añadirCadena("segundo");
		System.out.println(pila1.sacarCadena());
		pila1.añadirCadena("tercero");
		
		System.out.println(pila1.sacarCadena());
		System.out.println(pila1.sacarCadena());
		
		pila1.añadirCadena("cuarto");
		


	}

}
