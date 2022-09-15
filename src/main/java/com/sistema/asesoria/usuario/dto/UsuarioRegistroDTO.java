package com.sistema.asesoria.usuario.dto;

public class UsuarioRegistroDTO {
    
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String contrasenaUsuario;
    private Boolean estadoUsuario;
    private String  telefonoUsuario;
    private String tipoDocUsuario;
    private String  numeroDocUsuario;
    
    public UsuarioRegistroDTO() {
    }
    
    public UsuarioRegistroDTO(String nombreUsuario, String apellidoUsuario, String correoUsuario,
            String contrasenaUsuario, Boolean estadoUsuario, String telefonoUsuario, String tipoDocUsuario,
            String numeroDocUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.estadoUsuario = estadoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.tipoDocUsuario = tipoDocUsuario;
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
    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }
    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }
    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
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
}
