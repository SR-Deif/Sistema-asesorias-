package com.sistema.asesoria.usuario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired//traemos los repositorios
    private UsuarioRepository usuariorepository;
      //public String es porque me retorna a un archivo html

      //Lista
      @GetMapping("/usuarios")//redireccionar
      public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuariorepository.findAll();//mostrar todo lista
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuario/usuarios";//retornar
      }
      //Agregar Usuario
      @GetMapping("/usuarios/nuevo")
      public String mostrarFormularioDeNuevoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuario_formulario";
      }
      //guardar usuario
      @PostMapping("/usuarios/guardar")
      public String guardarUsuario(@Validated Usuario usuario){
        usuariorepository.save(usuario);
        return "redirect:/usuarios";
      }
      //editar usuario
      @GetMapping("/usuarios/editar/{idUsuario}")
      public String mostrarFormularioModificarUsuario(@PathVariable("idUsuario")Integer idUsuario,Model modelo){
        Usuario usuario = usuariorepository.findById(idUsuario).get();
        modelo.addAttribute("usuario", usuario);
        return "usuario/usuario_formulario";
      }
      //Eliminar usuario
      @GetMapping("/usuarios/eliminar/{idUsuario}")
      public String eliminarUsuario(@PathVariable("idUsuario")Integer idUsuario,Model modelo){
        usuariorepository.deleteById(idUsuario);
        return "redirect:/usuarios";
      }

      @PostMapping("/usuarios/nuevo")
      public String mostrarFormularioDeNuevoUsuario(@ModelAttribute @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
          if (bindingResult.hasErrors()) {
              return "usuario/usuario_formulario";
          }
          usuariorepository.save(usuario);
          redirectAttrs
                  .addFlashAttribute("mensaje", "Agregado correctamente")
                  .addFlashAttribute("clase", "success");
          return "redirect:/usuarios";
      }
  }


