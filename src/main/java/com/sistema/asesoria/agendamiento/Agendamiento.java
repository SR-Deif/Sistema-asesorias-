package com.sistema.asesoria.agendamiento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sistema.asesoria.asesoria.Asesoria;
import com.sistema.asesoria.solicitud.Solicitud;


@Entity
public class Agendamiento {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamiento;
    private String fechaAgendamiento;
    private String fechaRevisionAgendamiento;
    
    @OneToOne //uno a uno
    @JoinColumn(name="idSolicitud") //con la columna  a unir 
    private Solicitud solicitud;

    @OneToOne
    @JoinColumn(name="idAsesoria")//con la columna  a unir
    private Asesoria asesoria;

    //vacio
    public Agendamiento() {
    }

    public Agendamiento(int idAgendamiento) {
        this.idAgendamiento = idAgendamiento;
    }

    public Agendamiento(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Agendamiento(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Agendamiento(String fechaAgendamiento, String fechaRevisionAgendamiento, Solicitud solicitud,
            Asesoria asesoria) {
        this.fechaAgendamiento = fechaAgendamiento;
        this.fechaRevisionAgendamiento = fechaRevisionAgendamiento;
        this.solicitud = solicitud;
        this.asesoria = asesoria;
    }

    public Agendamiento(int idAgendamiento, String fechaAgendamiento, String fechaRevisionAgendamiento,
            Solicitud solicitud, Asesoria asesoria) {
        this.idAgendamiento = idAgendamiento;
        this.fechaAgendamiento = fechaAgendamiento;
        this.fechaRevisionAgendamiento = fechaRevisionAgendamiento;
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
