package com.sistema.asesoria.solicitud;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.asesoria.usuario.Usuario;


@Entity
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    private Boolean estado=null;

    private String descripcion;

    private String tipoSolicitud;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud, Usuario usuario, Boolean estado,
            String descripcion, String tipoSolicitud) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipoSolicitud = tipoSolicitud;
    }

    

    public Solicitud(Usuario usuario) {
        this.usuario = usuario;
    }  


    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }



    public Integer getIdSolicitud() {
        return idSolicitud;
    }


    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
    
}
