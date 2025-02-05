package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Pasaporte;
import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;
import com.example.demo.service.PasaporteService;
import com.example.demo.service.PersonaService;
import com.example.demo.service.ProyectoService;

@SpringBootApplication
public class Tema4Ejercicio18Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio18Application.class, args);
	}
	
	@Autowired
	private PasaporteService pasaporteService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ProyectoService proyectoService;
	
	
	@Override
	public void run(String... args) throws Exception {
		Persona persona1 = new Persona("Juan Perez");
		Persona persona2 = new Persona("Ana Lopez");
		Pasaporte pasaporte1 = new Pasaporte("ABC123", persona1);
		Pasaporte pasaporte2 = new Pasaporte("XYZ546", persona2);
		persona1.setPasaporte(pasaporte1);
		persona2.setPasaporte(pasaporte2);
		Proyecto proyecto1 = new Proyecto("Proyecto Alpha");
		Proyecto proyecto2 = new Proyecto("Proyecto beta");
		proyecto1.getPersonas().add(persona1);
		proyecto2.getPersonas().add(persona1);
		proyecto1.getPersonas().add(persona2);
		persona1.getProyectos().add(proyecto2);
		persona1.getProyectos().add(proyecto1);
		persona2.getProyectos().add(proyecto1);
		proyectoService.saveProyecto(proyecto1);
		proyectoService.saveProyecto(proyecto2);
		personaService.savePersona(persona1);
		personaService.savePersona(persona2);
		pasaporteService.savePasaporte(pasaporte1);
		pasaporteService.savePasaporte(pasaporte2);
		
		List<Persona> personas = personaService.getPersonas();
		personas.stream().forEach((per) -> {
			System.out.println(per.getName());
			per.getProyectos().stream().forEach((pro) -> {
				System.out.println("/t"+pro.getNombre());
			});
		});
	}
	
	

}
