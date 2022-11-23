package com.sistema.asesoria.agendamiento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.sistema.asesoria.asesoria.Asesoria;
import com.sistema.asesoria.solicitud.Solicitud;

@Entity
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamiento;
    private String fechaAgendamiento;
    @NotEmpty(message = "Debes elegir una fecha para Realizar la Asesoria")
    private String fechaRevisionAgendamiento;
    @NonNull
    private Boolean estado = false;

    @OneToOne(cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "idSolicitud") 
    private Solicitud solicitud;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "idAsesoria") 
    private Asesoria asesoria;

    public Agendamiento() {
    }

    public Agendamiento(int idAgendamiento) {
        this.idAgendamiento = idAgendamiento;
    }


    public Agendamiento(int idAgendamiento, String fechaAgendamiento,
            @NotEmpty(message = "Debes elegir una fecha para Realizar la Asesoria") String fechaRevisionAgendamiento,
            Boolean estado, Solicitud solicitud, Asesoria asesoria) {
        this.idAgendamiento = idAgendamiento;
        this.fechaAgendamiento = fechaAgendamiento;
        this.fechaRevisionAgendamiento = fechaRevisionAgendamiento;
        this.estado = estado;
        this.solicitud = solicitud;
        this.asesoria = asesoria;
    }

    public int getIdAgendamiento() {
        return idAgendamiento;
    }

    public void setIdAgendamiento(int idAgendamiento) {
        this.idAgendamiento = idAgendamiento;
    }

    public String getFechaAgendamiento() {
        return fechaAgendamiento;
    }

    public void setFechaAgendamiento(String fechaAgendamiento) {
        this.fechaAgendamiento = fechaAgendamiento;
    }

    public String getFechaRevisionAgendamiento() {
        return fechaRevisionAgendamiento;
    }

    public void setFechaRevisionAgendamiento(String fechaRevisionAgendamiento) {
        this.fechaRevisionAgendamiento = fechaRevisionAgendamiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    
}
