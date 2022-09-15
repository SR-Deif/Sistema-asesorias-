package com.sistema.asesoria.usuario;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;


@Entity
@Table(name ="usuario", uniqueConstraints = @UniqueConstraint(columnNames = "correoUsuario"))
public class Usuario {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @NotNull(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    private String nombreUsuario;

    @NotNull(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    private String apellidoUsuario;

    @Email (message = "Por favor validar el correo")
    private String correoUsuario;

    private String contrasenaUsuario;

    private Boolean estadoUsuario;

    @NotNull(message = "Debes especificar el Telefono")
    @Size(min = 1, max = 10, message = "El código debe medir entre 1 y 10")
    private String  telefonoUsuario;


    private String tipoDocUsuario;

    @NotNull(message = "Debes especificar el Documento")
    @Size(min = 1, max = 10, message = "El código debe medir entre 1 y 10")
    private String  numeroDocUsuario;
    

    private String tipoUsuario;
    

    public String  getTelefonoUsuario() {
        return telefonoUsuario;
    }
    public void setTelefonoUsuario(String  telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
    public String getTipoDocUsuario() {
        return tipoDocUsuario;
    }
    public void setTipoDocUsuario(String tipoDocUsuario) {
        this.tipoDocUsuario = tipoDocUsuario;
    }
    public String  getNumeroDocUsuario() {
        return numeroDocUsuario;
    }
    public void setNumeroDocUsuario(String  numeroDocUsuario) {
        this.numeroDocUsuario = numeroDocUsuario;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }
    public String getCorreoUsuario() {
        return correoUsuario;
    }
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }
    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }
    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    //constructor
    public Usuario() {
    }
    public Usuario(int idUsuario) {
        super();
        this.idUsuario = idUsuario;
    }
    public Usuario(String nombreUsuario, String apellidoUsuario, String correoUsuario, String contrasenaUsuario,
            String tipoUsuario, Boolean estadoUsuario) {
                super();
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.tipoUsuario = tipoUsuario;
        this.estadoUsuario = estadoUsuario;
    }
    public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
            String contrasenaUsuario, String tipoUsuario, Boolean estadoUsuario) {
                super();
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.tipoUsuario = tipoUsuario;
        this.estadoUsuario = estadoUsuario;
    }
    public Usuario(String nombreUsuario, String apellidoUsuario, String correoUsuario, String contrasenaUsuario,
    String tipoUsuario, Boolean estadoUsuario, String  telefonoUsuario, String tipoDocUsuario,
    String  numeroDocUsuario) {
        super();
this.nombreUsuario = nombreUsuario;
this.apellidoUsuario = apellidoUsuario;
this.correoUsuario = correoUsuario;
this.contrasenaUsuario = contrasenaUsuario;
this.tipoUsuario = tipoUsuario;
this.estadoUsuario = estadoUsuario;
this.telefonoUsuario = telefonoUsuario;
this.tipoDocUsuario = tipoDocUsuario;
this.numeroDocUsuario = numeroDocUsuario;
}
public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
    String contrasenaUsuario, String tipoUsuario, Boolean estadoUsuario, String  telefonoUsuario,
    String tipoDocUsuario, String  numeroDocUsuario) {
        super();
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.apellidoUsuario = apellidoUsuario;
this.correoUsuario = correoUsuario;
this.contrasenaUsuario = contrasenaUsuario;
this.tipoUsuario = tipoUsuario;
this.estadoUsuario = estadoUsuario;
this.telefonoUsuario = telefonoUsuario;
this.tipoDocUsuario = tipoDocUsuario;
this.numeroDocUsuario = numeroDocUsuario;
}

public Usuario(String tipoUsuario) {
    super();
    this.tipoUsuario = tipoUsuario;
}
  
}
