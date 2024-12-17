package com.example.demo.app;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

public class App {


	
	public static void main(String[] args) {
		UsuarioService servicioUsuario = new UsuarioService();
		for(Usuario usuario : servicioUsuario.getUsuarios()) {
			System.out.println(usuario);
		}

	}

}
