package com.sistema.asesoria.asesoria;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sistema.asesoria.agendamiento.Agendamiento;

@Entity
public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsesoria;

    @NotNull(message = "El precio es obligatorio")
    // @Size(min =10, max =1000, message ="El precio minimo es 10 y el precio maximo
    // es 1000")
    private String costoAsesoria;
    // @Size(min = 20, max = 200, message = "La descripcion minimo es 20 y maxima
    // 200")

    private String descripcionAsesoria;

    private Boolean estado = false;
    @OneToOne(cascade = { CascadeType.ALL }) // uno a uno
    @JoinColumn(name = "idAgendamiento") // con la columna a unir
    private Agendamiento agendamiento;

    public Asesoria() {
    }

    public Asesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Asesoria(int idAsesoria, @NotNull(message = "El precio es obligatorio") String costoAsesoria,
            String descripcionAsesoria, Boolean estado, Agendamiento agendamiento) {
        this.idAsesoria = idAsesoria;
        this.costoAsesoria = costoAsesoria;
        this.descripcionAsesoria = descripcionAsesoria;
        this.estado = estado;
        this.agendamiento = agendamiento;
    }

    public int getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public String getCostoAsesoria() {
        return costoAsesoria;
    }

    public void setCostoAsesoria(String costoAsesoria) {
        this.costoAsesoria = costoAsesoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcionAsesoria() {
        return descripcionAsesoria;
    }

    public void setDescripcionAsesoria(String descripcionAsesoria) {
        this.descripcionAsesoria = descripcionAsesoria;
    }

    public Agendamiento getAgendamiento() {
        return agendamiento;
    }

    public void setAgendamiento(Agendamiento agendamiento) {
        this.agendamiento = agendamiento;
    }

}
