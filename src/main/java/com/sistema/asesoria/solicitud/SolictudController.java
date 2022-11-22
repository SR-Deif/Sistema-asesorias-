package com.sistema.asesoria.solicitud;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

<<<<<<< HEAD
=======
// import com.sistema.asesoria.agendamiento.Agendamiento;
>>>>>>> 0a95e596744b4583a08fcd1ad5257fd2675af302
import com.sistema.asesoria.agendamiento.AgendamientoRepository;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.UsuarioRepository;

@Controller
public class SolictudController {

  @Autowired 
  private SolicitudRepository solicitudrepository;
  @Autowired
  private UsuarioRepository usuariorepository;
  @Autowired 
  private AgendamientoRepository agendamientorepository;


  @GetMapping("/solicituds")
  public String listarSolicituds(Model model) {
    List<Solicitud> listaSolicituds = solicitudrepository.findAll();
    model.addAttribute("listaSolicituds", listaSolicituds);
    return "solicitud/solicituds";
  }

  // formulario agregar
  @GetMapping("/solicituds/nuevo")
  public String mostrarFormularioDeNuevoSolicitud(Model model) {

    List<Usuario> listaUsuarios = usuariorepository.findAll();
    model.addAttribute("solicitud", new Solicitud());
    model.addAttribute("listaUsuarios", listaUsuarios);
    return "solicitud/solicitud_formulario";
  }

  // guardar
  @PostMapping("/solicituds/guardar")
  public String guardarSolicitud(Solicitud solicitud) {
    solicitudrepository.save(solicitud);
    return "redirect:/solicituds";
  }

  // editar
  @GetMapping("/solicituds/editar/{idSolicitud}")
  public String mostrarFormularioModeficarSolicitud(@PathVariable("idSolicitud") Integer idSolicitud, Model model) {
    Solicitud solicitud = solicitudrepository.findById(idSolicitud).get();
    model.addAttribute("solicitud", solicitud);
    //usuario
    List<Usuario> listaUsuarios = usuariorepository.findAll();
    model.addAttribute("listaClientes", listaUsuarios);
    return "solicitud/solicitud_formulario";
  }

  // eliminar
  @GetMapping("/solicituds/eliminar/{idSolicitud}")
  public String eliminarSolicitud(@PathVariable("idSolicitud") Integer idSolicitud, Model model) {
    solicitudrepository.deleteById(idSolicitud);
    return "redirect:/solicituds";
  }

  // Cambiar estado
  @GetMapping("/solicitud/estado/{idSolicitud}")
  public String estadoSolicitud(@PathVariable("idSolicitud") Integer idSolicitud, Model modelo) {
    Optional<Solicitud> solicitud = solicitudrepository.findById(idSolicitud);
    if (solicitud.get().getEstado() == true) {
      solicitud.get().setEstado(false);
    } else {
      solicitud.get().setEstado(true);
    }
    solicitudrepository.save(solicitud.get());
    return "redirect:/solicituds";
  }
}
