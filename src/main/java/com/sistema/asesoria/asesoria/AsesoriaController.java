package com.sistema.asesoria.asesoria;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.asesoria.agendamiento.Agendamiento;
import com.sistema.asesoria.agendamiento.AgendamientoRepository;
// import com.sistema.asesoria.solicitud.Solicitud;
// import com.sistema.asesoria.usuario.Usuario;

@Controller
public class AsesoriaController {
    
    @Autowired
    private AsesoriaRepository asesoriarepository;

    @Autowired
    private AgendamientoRepository agendamientorepository;
    // @Autowired
    // private UsuarioRepositorio usuarioRepository;


      //Lista
      @GetMapping("/asesoria")
      public String listarAsesoria(Model model){
        List<Asesoria> listaAsesoria = asesoriarepository.findAll();
        model.addAttribute("listaAsesoria", listaAsesoria);
        return "asesoria/asesoria";
      }

      //Lista
      @GetMapping("/asesoriaagro")
      public String listarAsesoriagro(Model model){
      List<Asesoria> listaAsesoria = asesoriarepository.findAll();
      model.addAttribute("listaAsesoria", listaAsesoria);
        return "asesoria/asesoria_agro";
      }

      //Agregar Usuario
      @GetMapping("/asesoria/nuevo")
      public String mostrarFormularioDeNuevaAsesoria(Model model){
        model.addAttribute("asesoria", new Asesoria());
        return "asesoria/asesoria_formulario";
      }

      //guardar usuario
      @PostMapping("/asesoria/guardar")
      public String guardarAsesoria(@Valid Asesoria asesoria, Authentication auth){
        asesoriarepository.save(asesoria);
        return "redirect:/asesoria";
      }
      //editar usuario
      @GetMapping("/asesoria/editar/{idAsesoria}")
      public String mostrarFormularioModificarAsesoria(@PathVariable("idAsesoria")Integer idAsesoria,Model modelo){
        Asesoria asesoria = asesoriarepository.findById(idAsesoria).get();
        modelo.addAttribute("asesoria", asesoria);

        return "asesoria/asesoria_formulario";
      }


      //Eliminar usuario
      @GetMapping("/asesoria/eliminar/{idAsesoria}")
      public String eliminarAsesoria(@PathVariable("idAsesoria")Integer idAsesoria,Model modelo){
        asesoriarepository.deleteById(idAsesoria);
        return "redirect:/asesoria";
      }

      @PostMapping("/asesoria/nuevo")
      public String mostrarFormularioDeNuevoAsesoria(@ModelAttribute @Valid Asesoria asesoria, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
          if (bindingResult.hasErrors()) {
              return "asesoria/asesoria_formulario";
          }
          asesoriarepository.save(asesoria);
          redirectAttrs
                  .addFlashAttribute("mensaje", "Agregado correctamente")
                  .addFlashAttribute("clase", "success");
          return "redirect:/asesoria";
     }

       // Cambiar estado
      @GetMapping("/asesoria/estado/{idAsesoria}")
      public String estadoasesoria(@PathVariable("idAsesoria") Integer idAsesoria, Model modelo) {
        Optional<Asesoria> asesoria = asesoriarepository.findById(idAsesoria);
        if (asesoria.get().getEstado() == false) {
          asesoria.get().setEstado(true);
        } else {
          asesoria.get().setEstado(false);
        }
        asesoriarepository.save(asesoria.get());
        return "redirect:/asesoria";
      }
      

            //email
            @GetMapping("/asesoria/email/{idAsesoria}")
            public String mostrarFormularioemail(@PathVariable("idAsesoria")Integer idAsesoria,Model modelo){
              Asesoria asesoria = asesoriarepository.findById(idAsesoria).get();
              modelo.addAttribute("asesoria", asesoria);
      
              List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();
              modelo.addAttribute("listaAgendamiento", listaAgendamiento);
      
              return "asesoria/email";
            }
 }
