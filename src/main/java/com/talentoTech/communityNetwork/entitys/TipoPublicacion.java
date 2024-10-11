package com.talentoTech.communityNetwork.entitys;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TipoPublicacion")
public class TipoPublicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    @Column(nullable = false, length = 100)
    private String nombreTipo;

    @OneToMany(mappedBy = "tipoPublicacion")
    private List<Publicacion> publicaciones;

    public TipoPublicacion(){
    }

    public void setNombreTipo(String anuncio) {
        this.nombreTipo = anuncio;
    }
}

