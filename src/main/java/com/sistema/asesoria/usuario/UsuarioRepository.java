package com.sistema.asesoria.usuario;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByEmail(String email);  
}
