package Ejercicio_1_repaso;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		Smartphone movil1 = new Smartphone();
		Smartphone movil2 = new Smartphone("a12345678910bcde");
		Smartphone movil3 = new Smartphone("a12345678910bcde", "samsung", "s24");
		
		BigDecimal precio = new BigDecimal(900);
		movil1.setPrecio(precio);
		
		movil1.activar();
		
		movil1.desactivar();
		
		LocalDate fechaFab = LocalDate.now();
		movil1.establecerFabricación(fechaFab);
		System.out.println(movil1.getEdad());
		
		movil1.cambiarMarcaModelo("iphone", "15 pro max");
		
		System.out.println(movil1.getPrecioMasIva());
		
		precio = new BigDecimal(400);
		if(movil1.isAltaGama(precio)) {
			System.out.println("Es alta gama");
		}else {
			System.out.println("No es alta gama");
		}
		
		if(movil1.isDatosCompletos()) {
			System.out.println("Los datos estan completos");
		}else {
			System.out.println("Los datos no estan completos");
		}
		
		if(movil1.isGratis()) {
			System.out.println("El tenefono es gratis");
		}else {
			System.out.println("El telefono no es gratis");
		}
		
		movil1.rebajar();
		
		System.out.println(movil1);
		
	}

}
