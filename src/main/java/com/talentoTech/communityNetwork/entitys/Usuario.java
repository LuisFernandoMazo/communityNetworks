package com.talentoTech.communityNetwork.entitys;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(nullable = false, length = 100, unique = true)
    private String cedula;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(nullable = false, length = 100)
    private String contrasena;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "usuarioPublicador")
    private List<Publicacion> publicaciones;

    public Usuario() {
    }

    public Usuario(String cedula, String nombre, String apellido, String telefono, String correo, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estado = true;
        this.rol = new Rol(1);
    }

    public String getNombre() {
        return this.nombre;
    }
}

