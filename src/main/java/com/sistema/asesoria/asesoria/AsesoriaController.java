package com.sistema.asesoria.asesoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AsesoriaController {
    
    @Autowired//traemos los repositorios
    private AsesoriaRepository asesoriarepository;
      //public String es porque me retorna a un archivo html


      //Lista
      @GetMapping("/asesoria")//redireccionar
      public String listarAsesoria(Model model){
        List<Asesoria> listaAsesoria = asesoriarepository.findAll();//mostrar todo lista
        model.addAttribute("listaAsesoria", listaAsesoria);
        return "asesoria/asesoria";//retornar
      }
      //Agregar Usuario
      @GetMapping("/asesoria/nuevo")
      public String mostrarFormularioDeNuevaAsesoria(Model model){
        model.addAttribute("asesoria", new Asesoria());
        return "asesoria/asesoria_formulario";
      }
      //guardar usuario
      @PostMapping("/asesoria/guardar")
      public String guardarAsesoria(Asesoria asesoria){
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


}
