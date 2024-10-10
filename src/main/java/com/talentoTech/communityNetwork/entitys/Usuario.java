package com.talentoTech.communityNetwork.entitys;

public class Usuario {
    private String identificador;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String contrasena;
    private String estado;
    private String perfil;
    private Rol rol;

    public Usuario(String identificador, String nombre, String apellido, String telefono, String correo, String contrasena) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = new Rol(1);
    }

}
