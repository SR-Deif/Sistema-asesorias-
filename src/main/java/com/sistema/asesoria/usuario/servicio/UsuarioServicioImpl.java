package com.sistema.asesoria.usuario.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.asesoria.usuario.Rol;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.dto.UsuarioRegistroDTO;
import com.sistema.asesoria.usuario.repositorio.UsuarioRepositorio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}



	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombreUsuario(), registroDTO.getApellidoUsuario(),
		registroDTO.getCorreoUsuario(),registroDTO.getContrasenaUsuario(),registroDTO.getEstadoUsuario(),
		registroDTO.getNumeroDocUsuario(),registroDTO.getTipoDocUsuario(),Arrays.asList(new Rol("ROL_USER")));
		return usuarioRepositorio.save(usuario);
	}
}
