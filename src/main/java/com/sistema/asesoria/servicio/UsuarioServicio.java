package com.sistema.asesoria.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sistema.asesoria.controlador.dto.UsuarioRegistroDTO;
import com.sistema.asesoria.usuario.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
