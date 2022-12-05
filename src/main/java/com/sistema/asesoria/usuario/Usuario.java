package com.sistema.asesoria.usuario;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sistema.asesoria.enumeraciones.Rol;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String tipoDocUsuario; 
	private String numeroDocUsuario;
    private String telefonoUsuario;
    private String direccion;
    private Boolean estado = true;

    //roles
    @Enumerated(EnumType.STRING)
    private Rol rol;

    
    //Contructores
    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido, String email, String password, String tipoDocUsuario,
            String numeroDocUsuario, String telefonoUsuario, String direccion, Boolean estado, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.tipoDocUsuario = tipoDocUsuario;
        this.numeroDocUsuario = numeroDocUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccion = direccion;
        this.estado = estado;
        this.rol = rol;
    }


    //GET and Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoDocUsuario() {
        return tipoDocUsuario;
    }

    public void setTipoDocUsuario(String tipoDocUsuario) {
        this.tipoDocUsuario = tipoDocUsuario;
    }

    public String getNumeroDocUsuario() {
        return numeroDocUsuario;
    }

    public void setNumeroDocUsuario(String numeroDocUsuario) {
        this.numeroDocUsuario = numeroDocUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    
}
