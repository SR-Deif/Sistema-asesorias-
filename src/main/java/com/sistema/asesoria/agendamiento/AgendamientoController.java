package com.sistema.asesoria.agendamiento;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.asesoria.solicitud.Solicitud;
import com.sistema.asesoria.solicitud.SolicitudRepository;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.UsuarioRepository;

@Controller
public class AgendamientoController {

  @Autowired // traemos los repositorios
  private AgendamientoRepository agendamientorepository;
  // public String es porque me retorna a un archivo html
  @Autowired
  private SolicitudRepository solicitudrepository;

  @Autowired
  private UsuarioRepository usuarioRepository;


  // Lista
  @GetMapping("/agendamiento") // redireccionar
  public String listarAgendamiento(Model model) {
    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();// mostrar todo lista
    model.addAttribute("listaAgendamiento", listaAgendamiento);
    return "agendamiento/agendamiento";// retornar
  }


  @GetMapping("/agendamientoFecha") // redireccionar
  public String listarAgendamientofecha(Model model) {
    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();// mostrar todo lista
    model.addAttribute("listaAgendamiento", listaAgendamiento);
    return "agendamiento/agendamiento_cliente";// retornar
  }

  // Agregar agendamiento
  @GetMapping("/agendamiento/nuevo")
  public String mostrarFormularioDeNuevaAgendamiento(Model model) {
    List<Solicitud> listaSolicitud = solicitudrepository.findAll();
    model.addAttribute("agendamiento", new Agendamiento());
    model.addAttribute("listaSolicituds", listaSolicitud);
    return "agendamiento/agendamiento_formulario";
  }

  // guardar agendamiento
  @PostMapping("/agendamiento/guardar")
  public String guardarAgendamiento(@Valid Agendamiento agendamiento, Authentication auth) {
    String username = ((UserDetails)auth.getPrincipal()).getUsername();
    Usuario usuario = usuarioRepository.findByEmail(username);
    if(agendamiento.getSolicitud()!=null){
      agendamiento.getSolicitud().setUsuario(usuario);
    }
    
    agendamientorepository.save(agendamiento);
    return "redirect:/agendamiento";
  }


  // editar agendamiento
  @GetMapping("/agendamiento/editar/{idAgendamiento}")
  public String mostrarFormularioModificarAgendamiento(@PathVariable("idAgendamiento") Integer idAgendamiento,
      Model modelo) {
    Agendamiento agendamiento = agendamientorepository.findById(idAgendamiento).get();
    modelo.addAttribute("agendamiento", agendamiento);

    List<Solicitud> listaSolicituds = solicitudrepository.findAll();
    modelo.addAttribute("listaSolicituds", listaSolicituds);
    return "agendamiento/formulario_cliente";
  }

  // Eliminar agendamiento
  @GetMapping("/agendamiento/eliminar/{idAgendamiento}")
  public String eliminarAgendamiento(@PathVariable("idAgendamiento") Integer idAgendamiento, Model modelo) {
    agendamientorepository.deleteById(idAgendamiento);
    return "redirect:/agendamiento";
  }

  // Cambiar estado
  @GetMapping("/agendamiento/estado/{idAgendamiento}")
  public String estadoAgendamiento(@PathVariable("idAgendamiento") Integer idAgendamiento, Model modelo) {
    Optional<Agendamiento> agendamiento = agendamientorepository.findById(idAgendamiento);
    if (agendamiento.get().getEstado() == true) {
      agendamiento.get().setEstado(false);
    } else {
      agendamiento.get().setEstado(true);
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
