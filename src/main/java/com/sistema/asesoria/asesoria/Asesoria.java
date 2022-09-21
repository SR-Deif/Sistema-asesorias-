package com.sistema.asesoria.asesoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsesoria;
    // parametros
    private String tipoAsesoria;
    @NotNull(message = "El precio es obligatorio")
    // @Size(min =10, max =1000, message ="El precio minimo es 10 y el precio maximo
    // es 1000")
    private String costoAsesoria;
    // @Size(min = 20, max = 200, message = "La descripcion minimo es 20 y maxima
    // 200")
    private String descripcionAsesoria;
    private Boolean estado=false;

    public Asesoria() {
    }

    public Asesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Asesoria(String tipoAsesoria, String costoAsesoria, String descripcionAsesoria, Boolean estadoAsesoria) {
        this.tipoAsesoria = tipoAsesoria;
        this.costoAsesoria = costoAsesoria;
        this.descripcionAsesoria = descripcionAsesoria;
        // this.estadoAsesoria = estadoAsesoria;
    }

    public Asesoria(int idAsesoria, String tipoAsesoria,
            @NotNull(message = "El precio es obligatorio") String costoAsesoria,
           String descripcionAsesoria, Boolean estado) {
        this.idAsesoria = idAsesoria;
        this.tipoAsesoria = tipoAsesoria;
        this.costoAsesoria = costoAsesoria;
        this.descripcionAsesoria = descripcionAsesoria;
        this.estado = estado;
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

    public String getCostoAsesoria() {
        return costoAsesoria;
    }

    public void setCostoAsesoria(String costoAsesoria) {
        this.costoAsesoria = costoAsesoria;
    }

    public String getDescripcionAsesoria() {
        return descripcionAsesoria;
    }

    public void setDescripcionAsesoria(String descripcionAsesoria) {
        this.descripcionAsesoria = descripcionAsesoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    

}
