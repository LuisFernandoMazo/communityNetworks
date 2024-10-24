package com.talentoTech.communityNetwork.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @Column(nullable = false)
    private String nombreDepartamento;

    @JsonManagedReference
    @OneToMany(mappedBy = "departamento")
    private List<Ciudad> ciudades;

    public Departamento(){
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombreDepartamento(Object nombre) {
        return nombreDepartamento;
    }

    public boolean estaRegistrado() {
        return idDepartamento > 0 && nombreDepartamento != null && !nombreDepartamento.isEmpty();
    }
    public void mostrarInformacion() {
        System.out.println("ID Departamento: " + idDepartamento);
        System.out.println("Nombre Departamento: " + nombreDepartamento);
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }


}
