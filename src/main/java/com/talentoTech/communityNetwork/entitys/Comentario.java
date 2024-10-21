package com.talentoTech.communityNetwork.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Comentarios")
public class Comentario {
    @Id
    @Column(nullable = false, length = 100, unique = true)
    private String idComentario;

    @Column(nullable = false, length = 300)
    private String comentario;

    private LocalDate fechaComentario;

    @ManyToOne(targetEntity = Publicacion.class)
    @JoinColumn(name = "Publicacion")
    private Publicacion publicacion;


}
