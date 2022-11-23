package com.sistema.asesoria.asesoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;


@Entity
public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsesoria;

    @NotNull(message = "El precio es obligatorio")
    private String costoAsesoria;

    private Boolean estado = false;


    public Asesoria() {
    }

    public Asesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Asesoria(int idAsesoria, @NotNull(message = "El precio es obligatorio") String costoAsesoria,
            Boolean estado) {
        this.idAsesoria = idAsesoria;
        this.costoAsesoria = costoAsesoria;

        this.estado = estado;
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


}
