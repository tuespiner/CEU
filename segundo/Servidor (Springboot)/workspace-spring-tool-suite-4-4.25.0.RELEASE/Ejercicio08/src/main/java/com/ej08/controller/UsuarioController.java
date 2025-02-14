package com.ej08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ej08.model.Usuario;
import com.ej08.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/{id}")
	public String indexId() {
		return "index";
	}
	
	@GetMapping("/verTodosLosUsuarios")
	public String verTodosLosUsuarios(Model model) {
		model.addAttribute("usuarios", service.getAllUsuarios());
		return "verTodosLosUsuarios";
	}
	
	
	@GetMapping("/usuario-form")
	public String usuarioForm(Model model){
		model.addAttribute("usuario" , new Usuario());
		return "usuario-form";
	}
	
	@GetMapping("/usuario-form/{id}")
	public String usuarioForm(@PathVariable("id") Integer id ,Model model) {
		model.addAttribute("usuarioPasado", this.service.getUsuarioById(id));
		return "usuario-form";
	}
	
	@PostMapping("/usuario-form")
	public String usuarioForm(@ModelAttribute Usuario usuario, Model model) {
		this.service.saveUsuario(usuario);
		return "redirect:/verTodosLosUsuarios";
	}
	
	@GetMapping("/primerUsuario")
	public String primerUsuario(Model model) {
		model.addAttribute("usuario", this.service.primerUsuarioDisponible());
		return "primerUsuario";
	}
	
}
