package com.example.demo.palindromo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class palindromoController {
	
	@GetMapping("validar-palindromo/{palindromo}")
	public String validarPalindromo(@PathVariable String palindromo){
		int longitud = palindromo.length();
		String[] igual = palindromo.split("");
		boolean noEsPalindromo = false;
		int j = igual.length-1;
		int mitad = (igual.length / 2);
		for(int i = 0;i<= mitad;i++) {
			if(!igual[i].equals(igual[j])) {
				noEsPalindromo = true;
			}
			j--;
		}
		if(noEsPalindromo == true) {
			return "No es palindromo";
		}else {
			return "Es palindromo" ;
		}
	}
	
}
