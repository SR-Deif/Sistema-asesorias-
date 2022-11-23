package com.sistema.asesoria.servicio;

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

import com.sistema.asesoria.controlador.dto.UsuarioRegistroDTO;
import com.sistema.asesoria.usuario.Rol;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getPassword())
		, registroDTO.getTelefonoUsuario(), registroDTO.getDetalleDireccion(), registroDTO.getDireccion(), registroDTO.getTipoDocUsuario(), registroDTO.getNumeroDocUsuario(), 
		registroDTO.getTipoUsuario(), registroDTO.getEstado(), Arrays.asList(new Rol("Rol_User")));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o Contraseña inválidos");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	private GrantedAuthority grantedAuthorities (Usuario usuario){
		GrantedAuthority authorities = new SimpleGrantedAuthority(usuario.getTipoUsuario().toUpperCase());

		return authorities;
}

}