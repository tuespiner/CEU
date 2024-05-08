package Ejercicio_15.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Ejercicio_15.Modelo.Pedido;
import Ejercicio_15.Modelo.PedidoLinea;
import Ejercicio_15.Modelo.Persona;
import Ejercicio_15.Servicios.NotFoundException;
import Ejercicio_15.Servicios.PedidoException;
import Ejercicio_15.Servicios.PedidosService;
import Ejercicio_15.Servicios.PersonaService;

public class App {
	private static Scanner sc = new Scanner(System.in);
	private static PedidosService ps = new PedidosService();

	public static void main(String[] args){
		Boolean salir = false;
		
		do{
			System.out.println("Elige una opción\n\t" + "1) Crear nuevo pedido\n\t" + "2) Ver pedido\n\t" + "3) salir");
			switch (sc.nextInt()) {
			case 1:
				try {
					crearPedido();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (PedidoException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Dime el numero del pedido que quieres ver");
					verPedido(sc.nextInt());
				} catch (PedidoException e) {
					System.out.println(e.getMessage());
				} catch (NotFoundException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				salir = true;
				break;

			}
		}while(salir != true);

		sc.close();
	}

	public static void crearPedido() throws PedidoException, SQLException {
		Pedido pedido = new Pedido();
		PedidoLinea pl = new PedidoLinea();
		Integer i = 0;
		System.out.println("Dime tu nombre");
		pedido.setCliente(sc.nextLine());
		System.out.println("Dime cuantas líneas va a tener el pedido");
		i = sc.nextInt();
		sc.nextLine();
		for (; i > 0; i--) {
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

		ps.crearPedidoCompleto(pedido);

	}

	public static void verPedido(Integer numero) throws PedidoException, NotFoundException {
		Pedido pedido = ps.consultarPedidoCompleto(numero);
		System.out.println(pedido);
	}
}

/*
 * for(int i = 0;i<3;i++) { Persona p = new Persona();
 * p.setNombre(cadNombreApellido); p.setApellidos(cadNombreApellido);
 * p.setDni(cadNombreApellido); p.setFechaNacimiento(fecha);
 * System.out.println(p); lista.add(p); cadNombreApellido = cadNombreApellido +
 * cadNombreApellido; } ps.insertarPersonas(lista);
 */