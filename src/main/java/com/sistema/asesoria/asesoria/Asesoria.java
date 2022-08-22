package com.sistema.asesoria.asesoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asesoria {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsesoria;
    //parametros
    private String tipoAsesoria;
    private Double costoAsesoria;
    private String descripcionAsesoria;
    private Boolean estadoAsesoria;
    
    public Asesoria() {
    }

    public Asesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Asesoria(String tipoAsesoria, Double costoAsesoria, String descripcionAsesoria, Boolean estadoAsesoria) {
        this.tipoAsesoria = tipoAsesoria;
        this.costoAsesoria = costoAsesoria;
        this.descripcionAsesoria = descripcionAsesoria;
        this.estadoAsesoria = estadoAsesoria;
    }

    public Asesoria(int idAsesoria, String tipoAsesoria, Double costoAsesoria, String descripcionAsesoria,
            Boolean estadoAsesoria) {
        this.idAsesoria = idAsesoria;
        this.tipoAsesoria = tipoAsesoria;
        this.costoAsesoria = costoAsesoria;
        this.descripcionAsesoria = descripcionAsesoria;
        this.estadoAsesoria = estadoAsesoria;
    }

    public int getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public String getTipoAsesoria() {
        return tipoAsesoria;
    }

    public void setTipoAsesoria(String tipoAsesoria) {
        this.tipoAsesoria = tipoAsesoria;
    }

    public Double getCostoAsesoria() {
        return costoAsesoria;
    }

    public void setCostoAsesoria(Double costoAsesoria) {
        this.costoAsesoria = costoAsesoria;
    }

    public String getDescripcionAsesoria() {
        return descripcionAsesoria;
    }

    public void setDescripcionAsesoria(String descripcionAsesoria) {
        this.descripcionAsesoria = descripcionAsesoria;
    }

    public Boolean getEstadoAsesoria() {
        return estadoAsesoria;
    }

    public void setEstadoAsesoria(Boolean estadoAsesoria) {
        this.estadoAsesoria = estadoAsesoria;
    }

}
