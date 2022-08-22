package com.sistema.asesoria.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    
    @Autowired//traemos los repositorios
    private ClienteRepository clienterepository;
    //public String es porque me retorna a un archivo html

    //Lista
    @GetMapping("/clientes")//redireccionar
    public String listarClientes(Model model){
        List<Cliente> listaClientes = clienterepository.findAll();//mostrar todo lista
        model.addAttribute("listaClientes", listaClientes);
        return "cliente/clientes";//retornar
      }

    //Agregar Cliente
    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeNuevoCliente(Model model){
      model.addAttribute("cliente", new Cliente());
      return "cliente/cliente_formulario";
    }   
    //guardar Cliente
    @PostMapping("/clientes/guardar")
    public String guardarCliente(Cliente cliente){
      clienterepository.save(cliente);
      return "redirect:/clientes";
    }
    //editar Cliente
    @GetMapping("/clientes/editar/{idCliente}")
    public String mostrarFormularioModificarCliente(@PathVariable("idCliente")Integer idCliente,Model modelo){
      Cliente cliente =  clienterepository.findById(idCliente).get();
      modelo.addAttribute("cliente", cliente);
      return "cliente/cliente_formulario";
    }
    //Eliminar usuario
    @GetMapping("/clientes/eliminar/{idCliente}")
    public String eliminarCliente(@PathVariable("idCliente")Integer idCliente,Model modelo){
      clienterepository.deleteById(idCliente);
      return "redirect:/clientes";
      }
    

    

    
}
