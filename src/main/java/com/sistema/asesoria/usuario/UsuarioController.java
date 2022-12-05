package com.sistema.asesoria.usuario;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuariorepository;


      //Lista
      @GetMapping("/usuarios") //ADMIN
      public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuariorepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuario/usuarios";
      }
      //Agregar Usuario
      @GetMapping("/usuarios/nuevo") //ADMIN
      public String mostrarFormularioDeNuevoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuario_formulario";
      }
      //guardar usuario
      @PostMapping("/usuarios/guardar") //ADMIN
      public String guardarUsuario(@Valid Usuario usuario){
        usuariorepository.save(usuario);
        return "redirect:/usuarios";
      }
      //editar usuario
      @GetMapping("/usuarios/editar/{id}") //ADMIN
      public String mostrarFormularioModificarUsuario(@PathVariable("id")Integer id,Model modelo){
        Usuario usuario = usuariorepository.findById(id).get();
        modelo.addAttribute("usuario", usuario);
        return "usuario/usuario_formulario";
      }
      //Eliminar usuario
      @GetMapping("/usuarios/eliminar/{id}") //ADMIN
      public String eliminarUsuario(@PathVariable("id")Integer id,Model modelo){
        usuariorepository.deleteById(id);
        return "redirect:/usuarios";
      }

      @PostMapping("/usuarios/nuevo") //ADMIN
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

        // Cambiar estado
  @GetMapping("/usuarios/estado/{id}") //ADMIN
  public String estadoAgendamiento(@PathVariable("id") Integer id, Model modelo) {
    Optional<Usuario> usuario = usuariorepository.findById(id);
    if (usuario.get().getEstado() == true) {
      usuario.get().setEstado(false);
    } else {
      usuario.get().setEstado(true);
    }
    usuariorepository.save(usuario.get());
    return "redirect:/usuarios";
  }
  }


