package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.examenA.service.PlanetaService;

@Controller
public class PlanetasController {
	
	@Autowired
	private PlanetaService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("planetas", service.listarTodos());
		return "index";
	}
	
	@GetMapping("/{id}")
	public String index(@PathVariable Long id, Model model) {
		this.service.eliminarPlaneta(id);
		return "redirect: @{/}";
	}
	
	
}
