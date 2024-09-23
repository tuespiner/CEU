package Ejercicio_47;

public class App {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("12345678X","Blas de los Montes");
		Carrito carrito1 = new Carrito(cliente1);
		Ropa ropa1 = new Ropa(20.0,"Poncho","XL","Azul");
		
		for(int i = 0; i<2;i++) {
			carrito1.addArticulo(ropa1);
		}
		
		System.out.println(carrito1);
		
		Libros libro1 = new Libros(15.0,"Así habló Zaratustra","Nietzsche");
		
		carrito1.addArticulo(libro1);
		
		System.out.println(carrito1);
		
		carrito1.borrarArticulo(1);
		System.out.println(carrito1);
		
		System.out.println(carrito1.getPrecioMedio());
		
		carrito1.vaciarCesta();
		System.out.println(carrito1);
		
		System.out.println(carrito1.getPrecioMedio());
	}

}
