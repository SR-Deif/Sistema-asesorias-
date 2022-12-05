package com.sistema.asesoria.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario findByEmail(@Param("email")String email);  

}
