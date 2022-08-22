package com.sistema.asesoria.solicitud;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.asesoria.usuario.Usuario;//importamos el modelo
import com.sistema.asesoria.cliente.Cliente;//importamos el modelo


@Entity
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    private String fechaCreacion;
    private Boolean estadoSolicitud;


    @ManyToOne//muchos a uno
    @JoinColumn(name = "idUsuario")//con la columna que se va a unir
    private Usuario usuario;

    @ManyToOne//muchos a uno
    @JoinColumn(name = "idCliente")//con la columna que se va a unir
    private Cliente cliente;

    //vacio
    public Solicitud() {
    }

    //relacion usuario
    public Solicitud(Usuario usuario) {
        this.usuario = usuario;
    }    

    //id
    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    //relacion cliente
    public Solicitud(Cliente cliente) {
        this.cliente = cliente;
    }

    //sin id
    public Solicitud(String fechaCreacion, Boolean estadoSolicitud, Usuario usuario) {
        this.fechaCreacion = fechaCreacion;
        this.estadoSolicitud = estadoSolicitud;
        this.usuario = usuario;
    }

    //todos
    public Solicitud(Integer idSolicitud, String fechaCreacion, Boolean estadoSolicitud, Usuario usuario,
            Cliente cliente) {
        this.idSolicitud = idSolicitud;
        this.fechaCreacion = fechaCreacion;
        this.estadoSolicitud = estadoSolicitud;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    //metodos accesores
    public Integer getIdSolicitud() {
        return idSolicitud;
    }


    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }


    public String getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public Boolean getEstadoSolicitud() {
        return estadoSolicitud;
    }


    public void setEstadoSolicitud(Boolean estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
