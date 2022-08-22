package com.sistema.asesoria.agendamiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendamientoController {

    @Autowired//traemos los repositorios
    private AgendamientoRepository agendamientorepository;
      //public String es porque me retorna a un archivo html

    //Lista
    @GetMapping("/agendamiento")//redireccionar
    public String listarAgendamiento(Model model){
      List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();//mostrar todo lista
      model.addAttribute("listaAgendamiento", listaAgendamiento);
      return "agendamiento/agendamiento";//retornar
    }

    //Agregar Usuario
    @GetMapping("/agendamiento/nuevo")
    public String mostrarFormularioDeNuevaAgendamiento(Model model){
      model.addAttribute("agendamiento", new Agendamiento());
      return "agendamiento/agendamiento_formulario";
    }
    //guardar usuario
    @PostMapping("/agendamiento/guardar")
    public String guardarAgendamiento(Agendamiento agendamiento){
      agendamientorepository.save(agendamiento);
      return "redirect:/agendamiento";
    }
    //editar usuario
    @GetMapping("/agendamiento/editar/{idAgendamiento}")
    public String mostrarFormularioModificarAgendamiento(@PathVariable("idAgendamiento")Integer idAgendamiento,Model modelo){
      Agendamiento agendamiento = agendamientorepository.findById(idAgendamiento).get();
      modelo.addAttribute("agendamiento", agendamiento);
      return "agendamiento/agendamiento_formulario";
    }
    //Eliminar usuario
    @GetMapping("/agendamiento/eliminar/{idAgendamiento}")
    public String eliminarAgendamiento(@PathVariable("idAgendamiento")Integer idAgendamiento,Model modelo){
      agendamientorepository.deleteById(idAgendamiento);
      return "redirect:/asesoria";
    }
}
