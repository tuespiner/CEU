package Ejercicio_37;

public class App {

	public static void main(String[] args) {
		ColaCadenas cola = new ColaCadenas();
		Boolean salir = false;
		
		cola.añadirCadena("primero");
		cola.añadirCadena("segundo");
		System.out.println(cola.sacarCadena());
		cola.añadirCadena("tercero");
		System.out.println(cola);
		while(salir== false) {
			System.out.println(cola);
			if(cola.sacarCadena() == null) {
				salir = true;
			}else {
				System.out.println(cola.sacarCadena());
			}

		}
		
		cola.añadirCadena("cuatro");
	}

}
