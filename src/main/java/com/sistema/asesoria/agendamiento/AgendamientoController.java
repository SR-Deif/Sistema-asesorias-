package com.sistema.asesoria.agendamiento;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.asesoria.asesoria.Asesoria;
import com.sistema.asesoria.asesoria.AsesoriaRepository;
import com.sistema.asesoria.solicitud.Solicitud;
import com.sistema.asesoria.solicitud.SolicitudRepository;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.UsuarioRepository;

@Controller
public class AgendamientoController {

  @Autowired 
  private AgendamientoRepository agendamientorepository;

  @Autowired
  private SolicitudRepository solicitudrepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private AsesoriaRepository asesoriarepository;


  // Lista
  @GetMapping("/agendamiento")
  public String listarAgendamiento(Model model) {
    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();
    model.addAttribute("listaAgendamiento", listaAgendamiento);
    return "agendamiento/agendamiento";
  }


  @GetMapping("/agendamientoFecha") 
  public String listarAgendamientofecha(Model model) {
    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();
    model.addAttribute("listaAgendamiento", listaAgendamiento);
    return "agendamiento/agendamiento_cliente";
  }

  // Agregar agendamiento
  @GetMapping("/agendamiento/nuevo")
  public String mostrarFormularioDeNuevaAgendamiento(Model model) {
    List<Solicitud> listaSolicitud = solicitudrepository.findAll();
    model.addAttribute("agendamiento", new Agendamiento());
    model.addAttribute("listaSolicituds", listaSolicitud);

    List<Asesoria> listaAsesoria = asesoriarepository.findAll();
    model.addAttribute("listaAsesoria", listaAsesoria);

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

    List<Asesoria> listaAsesoria = asesoriarepository.findAll();
    modelo.addAttribute("listaAsesoria", listaAsesoria);

    return "agendamiento/formulario_cliente";
  }

    // editar agendamiento
    @GetMapping("/agendamiento/costo/{idAgendamiento}")
    public String mostrarFormularioModificarAgendamientocosto(@PathVariable("idAgendamiento") Integer idAgendamiento,
        Model modelo) {
      Agendamiento agendamiento = agendamientorepository.findById(idAgendamiento).get();
      modelo.addAttribute("agendamiento", agendamiento);
  
      List<Solicitud> listaSolicituds = solicitudrepository.findAll();
      modelo.addAttribute("listaSolicituds", listaSolicituds);
  
      List<Asesoria> listaAsesoria = asesoriarepository.findAll();
      modelo.addAttribute("listaAsesoria", listaAsesoria);
  
      return "agendamiento/asesoria_formulario";
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
}
