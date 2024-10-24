package com.talentoTech.communityNetwork.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;

    @ManyToOne
    @JoinColumn(name = "idUsuarioPublicador", nullable = false)
    private Usuario usuarioPublicador;

    @ManyToOne
    @JoinColumn(name = "idTipoPublicacion", nullable = false)
    private TipoPublicacion tipoPublicacion;

    @ManyToOne
    @JoinColumn(name = "idCiudad", nullable = false)
    private Ciudad ciudad;

    private String direccion;

    @Column(nullable = false)
    private String titulo;

    @Lob
    private String descripcion;

    private LocalDateTime fechaPublicacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Column(nullable = false, length = 300)
    private String images;

    @OneToMany(targetEntity = Comentario.class,fetch =FetchType.LAZY, mappedBy = "comentario")
    private List<Comentario> comentario;

    public Publicacion(){

    }

}
