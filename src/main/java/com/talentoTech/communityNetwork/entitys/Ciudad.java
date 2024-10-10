package com.talentoTech.communityNetwork.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCiudad;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", nullable = false)
    private Departamento departamento;

    @Column(nullable = false)
    private String nombreCiudad;

    @OneToMany(mappedBy = "ciudad")
    private List<Publicacion> publicaciones;

    public Ciudad(){

    }
    public Ciudad(String nombreCiudad, Departamento dpto) {
        this.nombreCiudad = nombreCiudad;
        this.departamento = dpto;
    }

    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public boolean estaRegistrada() {
        return idCiudad > 0 && nombreCiudad != null && !nombreCiudad.isEmpty();
    }

    public void mostrarInformacion() {
        System.out.println("ID Ciudad: " + idCiudad);
        System.out.println("Nombre Ciudad: " + nombreCiudad);
    }
}
