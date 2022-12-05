package com.sistema.asesoria.agendamiento;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.DateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.DocumentException;
import com.sistema.asesoria.asesoria.Asesoria;
import com.sistema.asesoria.asesoria.AsesoriaRepository;
import com.sistema.asesoria.solicitud.Solicitud;
import com.sistema.asesoria.solicitud.SolicitudRepository;
import com.sistema.asesoria.usuario.Usuario;
import com.sistema.asesoria.usuario.UsuarioRepository;
import com.sistema.asesoria.util.reportes.AgendamientoExporterPDF;

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

  @GetMapping("/agendamientoconfirmar")
  public String listarAgendamientoconfirmar(Model model, Authentication auth) {
    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();
    String username = ((UserDetails) auth.getPrincipal()).getUsername();
    model.addAttribute("usuario", username);
    model.addAttribute("listaAgendamiento", listaAgendamiento);
    return "agendamiento/confirmacion_cliente";
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
    String username = ((UserDetails) auth.getPrincipal()).getUsername();
    Usuario usuario = usuarioRepository.findByEmail(username);
    if (agendamiento.getSolicitud() != null) {
      agendamiento.getSolicitud().setUsuario(usuario);
    }
    agendamientorepository.save(agendamiento);
    return "redirect:/agendamiento";
  }
  
  // guardar agendamiento asesoria
  @PostMapping("/agendamiento/guardar/asesoria")
  public String guardarAgendamientoAsesoria(@Valid Agendamiento agendamiento,  Authentication auth) {
    Agendamiento buscarAgendamiento = agendamientorepository.findById(agendamiento.getIdAgendamiento()).get();
    Usuario usuario = usuarioRepository.findByEmail(buscarAgendamiento.getSolicitud().getUsuario().getEmail());
    if (agendamiento.getSolicitud() != null) {
      agendamiento.getSolicitud().setUsuario(usuario);
    }
    agendamiento.setEstado(true);
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

  // Cambiar estado Pendiente
  @GetMapping("/agendamiento/estado/{idAgendamiento}/{estado}")
  public String estadoAgendamientoPendiente(@PathVariable("idAgendamiento") Integer idAgendamiento, @PathVariable("estado") Boolean estado, Model modelo) {
    Optional<Agendamiento> agendamiento = agendamientorepository.findById(idAgendamiento);
      agendamiento.get().setEstado(estado);
    agendamientorepository.save(agendamiento.get());
    return "redirect:/agendamiento";
  }

  @GetMapping("/exportarPDF")
  public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String fechaActual = dateFormatter.format(new Date());

    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=Agendamiento_" + fechaActual + ".pdf";

    response.setHeader(cabecera, valor);

    List<Agendamiento> listaAgendamiento = agendamientorepository.findAll();

    AgendamientoExporterPDF exporter = new AgendamientoExporterPDF(listaAgendamiento);
    exporter.exportar(response);

  }

}
