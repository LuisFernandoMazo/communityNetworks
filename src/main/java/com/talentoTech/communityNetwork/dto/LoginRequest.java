package com.talentoTech.communityNetwork.dto;

public class LoginRequest {
    private String correo;
    private String contrasena;

    public LoginRequest(){
    }

    public LoginRequest(String correo, String contrasena){
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}