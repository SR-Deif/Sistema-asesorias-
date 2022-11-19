package com.sistema.asesoria.controlador.dto;

public class UsuarioRegistroDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String telefonoUsuario;
	private String tipoDocUsuario; 
	private String numeroDocUsuario;
    private String tipoUsuario;
	private String detalleDireccion;
	private String direccion;
    private Boolean estado = true;



	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, String telefonoUsuario,
			String tipoDocUsuario, String numeroDocUsuario, String tipoUsuario, String detalleDireccion,
			String direccion, Boolean estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoDocUsuario = tipoDocUsuario;
		this.numeroDocUsuario = numeroDocUsuario;
		this.tipoUsuario = tipoUsuario;
		this.detalleDireccion = detalleDireccion;
		this.direccion = direccion;
		this.estado = estado;
	}



	public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String password,
			String telefonoUsuario, String tipoDocUsuario, String numeroDocUsuario, String tipoUsuario,
			String detalleDireccion, String direccion, Boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoDocUsuario = tipoDocUsuario;
		this.numeroDocUsuario = numeroDocUsuario;
		this.tipoUsuario = tipoUsuario;
		this.detalleDireccion = detalleDireccion;
		this.direccion = direccion;
		this.estado = estado;
	}

	public UsuarioRegistroDTO(String email) {
		this.email = email;
	}

	public UsuarioRegistroDTO() {

	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
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

	public String getTipoDocUsuario() {
		return tipoDocUsuario;
	}

	public void setTipoDocUsuario(String tipoDocUsuario) {
		this.tipoDocUsuario = tipoDocUsuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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

	

}
