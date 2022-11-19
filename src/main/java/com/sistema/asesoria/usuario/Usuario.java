package com.sistema.asesoria.usuario;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	private String email;

	private String password;

	private String telefonoUsuario;

	private String detalleDireccion;

	private String direccion;

	private String tipoDocUsuario; 

	private String numeroDocUsuario;

    private String tipoUsuario;

    private Boolean estado = true;
    
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
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

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getDetalleDireccion() {
		return detalleDireccion;
	}

	public void setDetalleDireccion(String detalleDireccion) {
		this.detalleDireccion = detalleDireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Usuario(Long id, String nombre, String apellido, String email, String password, String telefonoUsuario,
			String detalleDireccion, String direccion, String tipoDocUsuario, String numeroDocUsuario,
			String tipoUsuario, Boolean estado, Collection<Rol> roles) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefonoUsuario = telefonoUsuario;
		this.detalleDireccion = detalleDireccion;
		this.direccion = direccion;
		this.tipoDocUsuario = tipoDocUsuario;
		this.numeroDocUsuario = numeroDocUsuario;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado;
		this.roles = roles;
	}

	public Usuario(String nombre, String apellido, String email, String password, String telefonoUsuario,
			String detalleDireccion, String direccion, String tipoDocUsuario, String numeroDocUsuario,
			String tipoUsuario, Boolean estado, Collection<Rol> roles) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefonoUsuario = telefonoUsuario;
		this.detalleDireccion = detalleDireccion;
		this.direccion = direccion;
		this.tipoDocUsuario = tipoDocUsuario;
		this.numeroDocUsuario = numeroDocUsuario;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado;
		this.roles = roles;
	}

	public Usuario() {
	}

	public Usuario(String email) {
		this.email = email;
	}

	public Usuario(Long id) {
		this.id = id;
	}


}
