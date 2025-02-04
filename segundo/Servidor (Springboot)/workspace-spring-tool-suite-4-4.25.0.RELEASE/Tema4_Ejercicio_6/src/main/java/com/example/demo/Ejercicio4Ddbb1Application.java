package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.service.ClienteService;

@SpringBootApplication
public class Ejercicio4Ddbb1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio4Ddbb1Application.class, args);
	}
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente("Pepe Ruiz", new Direccion("Calle Sol", "Oviedo"));
		Cliente cliente2 = new Cliente("Andres Ramirez", new Direccion("Calle Mar", "Cadiz"));
		clienteService.saveCliente(cliente1);
		clienteService.saveCliente(cliente2);
	}
	
	
}
