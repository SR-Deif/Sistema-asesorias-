package com.sistema.asesoria.solicitud;


// import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;

import com.sistema.asesoria.usuario.Usuario;//importamos el modelo


@Entity
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    private String fechaCreacion;

    @ManyToOne//muchos a uno
    @JoinColumn(name = "id")//con la columna que se va a unir
    private Usuario usuario;

    private Boolean estado=false;

    private String descripcion;

    private String tipoSolicitud;


    //vacio
    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud, String fechaCreacion, Usuario usuario, Boolean estado,
            String descripcion, String tipoSolicitud) {
        this.idSolicitud = idSolicitud;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipoSolicitud = tipoSolicitud;
    }

    //relacion usuario
    public Solicitud(Usuario usuario) {
        this.usuario = usuario;
    }  

    //id
    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
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
