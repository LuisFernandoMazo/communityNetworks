package com.talentoTech.communityNetwork.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
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

    public boolean estaRegistrada() {
        return idCiudad > 0 && nombreCiudad != null && !nombreCiudad.isEmpty();
    }

    public void mostrarInformacion() {
        System.out.println("ID Ciudad: " + idCiudad);
        System.out.println("Nombre Ciudad: " + nombreCiudad);
    }

    public String getNombre() {
         return this.nombreCiudad;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }
}
