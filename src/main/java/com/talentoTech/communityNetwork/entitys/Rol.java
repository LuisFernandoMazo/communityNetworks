package com.talentoTech.communityNetwork.entitys;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idRol;

    @Column(nullable = false, unique = true)
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdRole() {
        return idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String user) {
        this.nombreRol = user;
    }
}
