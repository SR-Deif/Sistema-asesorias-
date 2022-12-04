package com.sistema.asesoria.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.asesoria.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/index")
	public String inicio() {
		return "login";
	}

	@GetMapping("/login")
	public String iniciarSesion() {
		return "index";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("listaUsuarios", servicio.listarUsuarios());
		return "dasboard";
	}

}
