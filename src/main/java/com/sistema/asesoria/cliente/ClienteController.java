package com.sistema.asesoria.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClienteController {
    
    @Autowired//traemos los repositorios
    private ClienteRepository agro;
    //public String es porque me retorna a un archivo html

    //Lista
    @GetMapping("/clientes")//redireccionar
    public String listarClientes(Model m){
        List<Cliente> listaClientes = agro.findAll();//mostrar todo lista
        m.addAttribute("listaClientes", listaClientes);
        return "cliente/clientes";//retornar
      }

    //Agregar Cliente
    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeNuevoCliente(Model m){
      m.addAttribute("clientes", new Cliente());
      return "cliente/cliente_formulario";
    }   
    //guardar Cliente
    @PostMapping("/clientes/guardar")
    public String guardarCliente(@Valid Cliente cliente){
      agro.save(cliente);
      return "redirect:/clientes";
    }
    //editar Cliente
    @GetMapping("/clientes/editar/{id_Cliente}")
    public String mostrarFormularioModificarCliente(@PathVariable("id_Cliente")Integer id_Cliente,Model modelo){
      Cliente cliente =  agro.findById(id_Cliente).get();
      modelo.addAttribute("clientes", cliente);
      return "cliente/cliente_formulario";
    }
    //Eliminar usuario
    @GetMapping("/clientes/eliminar/{id_Cliente}")
    public String eliminarCliente(@PathVariable("id_Cliente")Integer id_Cliente,Model modelo){
      agro.deleteById(id_Cliente);
      return "redirect:/clientes";
      }
// [    
//     @GetMapping(value="path")
//     public SomeData getMethodName(@RequestParam String param) {
//         return new SomeData();
//     }
//       ]
}
