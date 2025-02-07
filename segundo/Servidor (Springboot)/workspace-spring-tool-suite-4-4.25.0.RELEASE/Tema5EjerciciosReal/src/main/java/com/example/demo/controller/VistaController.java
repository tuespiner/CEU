package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

@Controller
public class VistaController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("clientes", service.getAllClientes());
		
		return "index";
	}
	

	
	@GetMapping("/detallesCliente")
	public String detallesCliente(  Model model) {
		return "detallesCliente";
	}
	

	
	@GetMapping("/agregarCliente")
	public String agregarCliente( Model model) {
		model.addAttribute("clienteNuevo", new Cliente());
		return "agregarCliente";
	}
	
	@PostMapping("/agregarCliente")
	public String agregarCliente(@ModelAttribute Cliente cliente, Model model) {
		model.addAttribute("clienteNuevo", cliente);
		service.saveCliente(cliente);
		return "index";
	}
}
