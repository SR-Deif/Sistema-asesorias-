package com.sistema.asesoria.agendamiento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.sistema.asesoria.solicitud.Solicitud;

@Entity
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamiento;
    @NotEmpty(message = "Debes elegir una fecha a Agendar ")
    private String fechaAgendamiento;
    @NotEmpty(message = "Debes elegir una fecha para Realizar la Asesoria")
    private String fechaRevisionAgendamiento;
    @NonNull
    private Boolean estado = false;

    @OneToOne // uno a uno
    @JoinColumn(name = "idSolicitud") // con la columna a unir
    private Solicitud solicitud;

    // vacio
    public Agendamiento() {
    }

    public Agendamiento(int idAgendamiento) {
        this.idAgendamiento = idAgendamiento;
    }

    public Agendamiento(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Agendamiento(int idAgendamiento,
            @NotEmpty(message = "Debes elegir una fecha a Agendar ") String fechaAgendamiento,
            @NotEmpty(message = "Debes elegir una fecha para Realizar la Asesoria") String fechaRevisionAgendamiento,
            Boolean estado, Solicitud solicitud) {
        this.idAgendamiento = idAgendamiento;
        this.fechaAgendamiento = fechaAgendamiento;
        this.fechaRevisionAgendamiento = fechaRevisionAgendamiento;
        this.estado = estado;
        this.solicitud = solicitud;
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

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
