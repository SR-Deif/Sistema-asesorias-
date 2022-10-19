package com.sistema.asesoria.solicitud;

import java.util.List;
import java.util.Optional;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.asesoria.cliente.Cliente;
import com.sistema.asesoria.cliente.ClienteRepository;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.UsuarioRepository;

@Controller
public class SolictudController {

  @Autowired // traemos los repositorios
  private SolicitudRepository solicitudrepository;
  @Autowired
  private UsuarioRepository usuariorepository;
  @Autowired
  private ClienteRepository clienteRepository;

  // lista
  @GetMapping("/solicituds")
  public String listarSolicituds(Model model) {
    List<Solicitud> listaSolicituds = solicitudrepository.findAll();
    model.addAttribute("listaSolicituds", listaSolicituds);
    return "solicitud/solicituds";
  }

  // formulario agregar
  @GetMapping("/solicituds/nuevo")
  public String mostrarFormularioDeNuevoSolicitud(Model model) {
    // aqui le pasamos una nueva instancia de solicitud para asi poder asignar a los
    // campos en el html
    List<Usuario> listaUsuarios = usuariorepository.findAll();
    List<Cliente> listaClientes = clienteRepository.findAll();
    model.addAttribute("solicitud", new Solicitud());
    model.addAttribute("listaClientes", listaClientes);
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
    // cliente
    List<Cliente> listaClientes = clienteRepository.findAll();
    model.addAttribute("listaClientes", listaClientes);
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
    if (solicitud.get().getEstado() == false) {
      solicitud.get().setEstado(true);
    } else {
      solicitud.get().setEstado(false);
    }
    solicitudrepository.save(solicitud.get());
    return "redirect:/solicituds";
  }
}
