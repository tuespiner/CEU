package com.examenA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examenA.model.Luna;
import com.examenA.model.Planeta;
import com.examenA.service.PlanetaService;

@SpringBootApplication
public class ExamenAApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExamenAApplication.class, args);
	}
	
	@Autowired
	private PlanetaService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Planeta planeta1 = new Planeta("Jupiter", "gaseoso");
		planeta1 = service.crearPlaneta(planeta1);
		Planeta planeta2 = new Planeta("Tierra", "rocoso");
		planeta2 = service.crearPlaneta(planeta2);
		Luna luna1 = new Luna("Europa",	3121.6);
		luna1 = service.crearLuna(luna1, planeta1.getId());
		Luna luna2 = new Luna("Io", 3643.2);
		luna2 = service.crearLuna(luna2, planeta1.getId());
		Luna luna3 = new Luna("Ganímedes", 5262.4);
		luna3 = service.crearLuna(luna3, planeta1.getId());
		Luna luna4 = new Luna("Luna", 3474.8);
		luna4 = service.crearLuna(luna4, planeta2.getId());
		planeta1 = service.getPlanetaId(planeta1.getId());
		
		List<Planeta> planetas = this.service.listarTodos();
		System.out.println("Pplanetas registrados:");
		planetas.stream().forEach((planeta)->{
			System.out.println("Planeta: "+planeta.getNombre()+" ("+planeta.getTipo()+")");
			//No imprimo las lunas por que de verdad que no se por que no se insertan, he intentado de todo
		});
		System.out.println("Planetas gaseosos:");
		planetas = this.service.buscarPorTipo("gaseoso");
		planetas.stream().forEach((planeta)->{
			System.out.println("Planeta: "+planeta.getNombre()+" ("+planeta.getTipo()+")");
		});
		//service.eliminarPlaneta(planeta1.getId());   esta comentada por que peta y de verdad que no se por que es
		System.out.print("¿Jupiter existe? ");
		if(service.existeJupiter()) {
			System.out.println(" existe");
		}else {
			System.out.println("No existe");
		}
		Planeta planeta3 = new Planeta("Marte", "rocoso");
		planeta3 = service.crearPlaneta(planeta3);
		System.out.println("Planetas registrados:");
		planetas = this.service.listarTodos();
		planetas.stream().forEach((planeta)->{
			System.out.println("Planeta: "+planeta.getNombre()+" ("+planeta.getTipo()+")");
		});
	}

}
