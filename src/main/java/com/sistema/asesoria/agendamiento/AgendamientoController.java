package com.sistema.asesoria.agendamiento;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.asesoria.asesoria.Asesoria;
import com.sistema.asesoria.asesoria.AsesoriaRepository;

@Controller
public class AgendamientoController {

  @Autowired // traemos los repositorios
  private AgendamientoRepository agendamientorepository;
  // public String es porque me retorna a un archivo html
  @Autowired
  private AsesoriaRepository asesoriarepository;

  // Lista
  @GetMapping("/agendamiento") // redireccionar
  public String listarAgendamiento(Model model) {
    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();// mostrar todo lista
    model.addAttribute("listaAgendamiento", listaAgendamiento);
    return "agendamiento/agendamiento";// retornar
  }

  // Agregar agendamiento
  @GetMapping("/agendamiento/nuevo")
  public String mostrarFormularioDeNuevaAgendamiento(Model model) {
    List<Asesoria> listaAsesoria = asesoriarepository.findAll();// poder alistar todas los agendamientos
    // aqui le pasamos una nueva instancia de solicitud para asi poder asignar a los
    // campos en el html
    model.addAttribute("agendamiento", new Agendamiento());
    model.addAttribute("listaAsesoria", listaAsesoria);// aqui agregamos la lista
    return "agendamiento/agendamiento_formulario";
  }

  // guardar agendamiento
  @PostMapping("/agendamiento/guardar")
  public String guardarAgendamiento(@Valid Agendamiento agendamiento) {
    agendamientorepository.save(agendamiento);
    return "redirect:/agendamiento";
  }

  // editar agendamiento
  @GetMapping("/agendamiento/editar/{idAgendamiento}")
  public String mostrarFormularioModificarAgendamiento(@PathVariable("idAgendamiento") Integer idAgendamiento,
      Model modelo) {
    Agendamiento agendamiento = agendamientorepository.findById(idAgendamiento).get();
    modelo.addAttribute("agendamiento", agendamiento);
    return "agendamiento/agendamiento_formulario";
  }

  // Eliminar agendamiento
  @GetMapping("/agendamiento/eliminar/{idAgendamiento}")
  public String eliminarAgendamiento(@PathVariable("idAgendamiento") Integer idAgendamiento, Model modelo) {
    agendamientorepository.deleteById(idAgendamiento);
    return "redirect:/asesoria";
  }

  // Cambiar estado
  @GetMapping("/agendamiento/estado/{idAgendamiento}")
  public String estadoAgendamiento(@PathVariable("idAgendamiento") Integer idAgendamiento, Model modelo) {
    Optional<Agendamiento> agendamiento = agendamientorepository.findById(idAgendamiento);
    if (agendamiento.get().getEstado() == false) {
      agendamiento.get().setEstado(true);
    } else {
      agendamiento.get().setEstado(false);
    }
    agendamientorepository.save(agendamiento.get());
    return "redirect:/agendamiento";
  }
  /*
   * @PostMapping("/agendamiento/nuevo")
   * public String mostrarFormularioDeNuevoAgendamiento(@ModelAttribute @Valid
   * Agendamiento agendamiento, BindingResult bindingResult, RedirectAttributes
   * redirectAttrs) {
   * if (bindingResult.hasErrors()) {
   * return "agendamiento/agendamiento_formulario";
   * }
   * agendamientorepository.save(agendamiento);
   * redirectAttrs
   * .addFlashAttribute("mensaje", "Agregado correctamente")
   * .addFlashAttribute("clase", "success");
   * return "redirect:/agendamiento";
   */
}
