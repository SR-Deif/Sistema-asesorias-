package com.sistema.asesoria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@GetMapping("")
	public String verPaginaDeInicio() {
		return "index";
	}
	
	@PostMapping("/","","formularioprincipal")
	public String principal(){
		return "formularioprincipal";
	}
}
