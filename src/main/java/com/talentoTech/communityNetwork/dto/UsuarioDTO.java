package com.talentoTech.communityNetwork.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private List<?> publicaciones;

    public List<?> getPublicaciones() {
        return publicaciones;
    }

    public UsuarioDTO(String nombre, String apellido, String correo, String telefono, List<?> publicaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.publicaciones = publicaciones;
        System.out.println(publicaciones);
    }

    public UsuarioDTO(String nombre, String apellido, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.publicaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
