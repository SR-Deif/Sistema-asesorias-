package com.sistema.asesoria.usuario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.asesoria.usuario.dto.UsuarioRegistroDTO;
import com.sistema.asesoria.usuario.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){

        return new UsuarioRegistroDTO();
    }
    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}
