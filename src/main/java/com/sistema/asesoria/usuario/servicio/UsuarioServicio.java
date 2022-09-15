package com.sistema.asesoria.usuario.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.dto.UsuarioRegistroDTO;


public interface UsuarioServicio extends UserDetailsService{
    
    public Usuario guardar(UsuarioRegistroDTO registroDTO);

	
	public List<Usuario> listarUsuarios();
}
