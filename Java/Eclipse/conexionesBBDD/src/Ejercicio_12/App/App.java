package Ejercicio_12.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Ejercicio_12.Modelo.Pedido;
import Ejercicio_12.Modelo.PedidoLinea;
import Ejercicio_12.Modelo.Persona;
import Ejercicio_12.Servicios.PersonaService;

public class App {
	private static Scanner sc = new Scanner(System.in);
	private static PersonaService ps = new PersonaService();
	public static void main(String[] args) throws SQLException {
		
		
		
		sc.close();
	}
	
	public void menu() {
		System.out.println("Elige una opción/n/t"
						 + "1) Crear nuevo pedido/n/t"
						 + "2) Ver pedido/b/t"
						 + "3) salir");
		switch (sc.nextInt()){
			case 1:
				
		}
	}
	
	public void crearPedido() {
		Pedido pedido = new Pedido();
		PedidoLinea pl = new PedidoLinea();
		Integer i = 0;
		System.out.println("Dime tu nombre");
		pedido.setCliente(sc.nextLine());
		System.out.println("Dime cuantas líneas va a tener el pedido");
		i = sc.nextInt();sc.nextLine();
		for(; i>0;i--) {
			pl = new PedidoLinea();
			System.out.println("Dime el articulo");
			pl.setArticulo(sc.nextLine());
			System.out.println("Dime la cantidad");
			pl.setCantidad(sc.nextInt());
			System.out.println("Dime el precio exacto");
			pl.setPrecioUnitario(sc.nextBigDecimal());
			pl.setNumeroPedido(pedido.getNumero());
			pedido.getPedidoLinea().add(pl);
		}
	}
}



/*for(int i = 0;i<3;i++) {
			Persona p = new Persona();
			p.setNombre(cadNombreApellido);
			p.setApellidos(cadNombreApellido);
			p.setDni(cadNombreApellido);
			p.setFechaNacimiento(fecha);
			System.out.println(p);
			lista.add(p);
			cadNombreApellido = cadNombreApellido + cadNombreApellido;
		}
		ps.insertarPersonas(lista);*/