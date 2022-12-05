package com.sistema.asesoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistema.asesoria.usuario.UsuarioServicio;

@Controller
public class AppController {


	@Autowired 
	private UsuarioServicio usuarioServicio;

	@GetMapping("/")
	public String verPaginaDeInicio() {
		return "/index";
	}
	
	@GetMapping("/registrar")
	public String registrar(){
		return "/registro";
	}

	@PostMapping("/registro")
	public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam String password, @RequestParam String tipoDocUsuario,
	@RequestParam String numeroDocUsuario, @RequestParam String telefonoUsuario, @RequestParam String direccion, ModelMap m){

		try {
			usuarioServicio.registrar(nombre, apellido, email, password, tipoDocUsuario, numeroDocUsuario, telefonoUsuario, direccion);
		
			m.put("Exito", "Usuario registrado correctamente");

			return "/registro";
		} catch (Exception e) {

			m.put("error", e.getMessage());

			return "/registro";
		}

	}

	@GetMapping("/login")
	public String login(@RequestParam(required = false) String error, ModelMap m){
		if (error != null) {
			m.put("error", "Usuario contraseña o email incorrectas");
		} 
		return "/login";
	}

	@PreAuthorize("hasAnyRole('ROLE_CLIENTE', 'ROLE_ADMIN', 'ROLE_ING')")
	@GetMapping("/dasboard")
	public String dasboard(){
		return "/dasboard";
	}
}
