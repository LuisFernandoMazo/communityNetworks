package com.talentoTech.communityNetwork.entitys;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @Column(nullable = false)
    private String nombreDepartamento;

    @OneToMany(mappedBy = "departamento")
    private List<Ciudad> ciudades;

    public Departamento(){

    }
    public Departamento(int idDepartamento, String nombreDepartamento, List<Ciudad> ciudades) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.ciudades = ciudades;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public boolean estaRegistrado() {
        return idDepartamento > 0 && nombreDepartamento != null && !nombreDepartamento.isEmpty();
    }
    public void mostrarInformacion() {
        System.out.println("ID Departamento: " + idDepartamento);
        System.out.println("Nombre Departamento: " + nombreDepartamento);
    }
}
