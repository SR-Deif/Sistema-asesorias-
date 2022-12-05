package com.sistema.asesoria.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.asesoria.enumeraciones.Rol;


@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(String nombre, String apellido, String email, String password, String tipoDocUsuario,
    String numeroDocUsuario, String telefonoUsuario, String direccion) throws Exception{

        validar ( nombre,  apellido,  email,  password,  tipoDocUsuario,
         numeroDocUsuario,  telefonoUsuario,  direccion); 

         Usuario usuario = new Usuario();

         usuario.setNombre(nombre);
         usuario.setApellido(apellido);
         usuario.setEmail(email);
         usuario.setPassword(new BCryptPasswordEncoder().encode(password));
         usuario.setTipoDocUsuario(tipoDocUsuario);
         usuario.setNumeroDocUsuario(numeroDocUsuario);
         usuario.setTelefonoUsuario(telefonoUsuario);
         usuario.setDireccion(direccion);

         usuario.setRol(Rol.CLIENTE);

         usuarioRepositorio.save(usuario);
    }

    private void validar(String nombre, String apellido, String email, String password, String tipoDocUsuario,
            String numeroDocUsuario, String telefonoUsuario, String direccion) throws Exception{

                if (nombre.isEmpty() || nombre == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }
                if (apellido.isEmpty() || apellido == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }
                if (email.isEmpty() || email == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }
                if (password.isEmpty() || password == null || password.length() <=5)  {
                    throw new Exception("No puede estar vacio el campo y debe tener mas de 5 digitos");
                    
                }
                if (tipoDocUsuario.isEmpty() || tipoDocUsuario == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }
                if (numeroDocUsuario.isEmpty() || numeroDocUsuario == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }
                if (telefonoUsuario.isEmpty() || telefonoUsuario == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }
                if (direccion.isEmpty() || nombre == null)  {
                    throw new Exception("No puede estar vacio el campo");
                    
                }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);

        if (usuario != null) {
            
            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+usuario.getRol().toString()); //concatenación ROLE_CLIENTE

            permisos.add(p);

            return new User(usuario.getEmail(), usuario.getPassword(),permisos);
        }else{
            return null;
        }
    }

    
}
