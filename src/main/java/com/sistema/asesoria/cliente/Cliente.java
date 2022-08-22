package com.sistema.asesoria.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String detalleDireccionCliente;

    //vacio
    public Cliente() {
    }

    //Id
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //sin id
    public Cliente(String nombreCliente, String apellidoCliente, String direccionCliente, String correoCliente,
            String telefonoCliente, String detalleDireccionCliente) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.detalleDireccionCliente = detalleDireccionCliente;
    }

    //todo
    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String direccionCliente,
            String correoCliente, String telefonoCliente, String detalleDireccionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.detalleDireccionCliente = detalleDireccionCliente;
    }

    //metodos accesores
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDetalleDireccionCliente() {
        return detalleDireccionCliente;
    }

    public void setDetalleDireccionCliente(String detalleDireccionCliente) {
        this.detalleDireccionCliente = detalleDireccionCliente;
    }
   
}
