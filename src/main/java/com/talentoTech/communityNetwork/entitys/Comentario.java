package com.talentoTech.communityNetwork.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Comentarios")
public class Comentario {
    @Id
    @Column(nullable = false, length = 100, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @Column(nullable = false, length = 300)
    private String comentario;

    private LocalDate fechaComentario;

    @ManyToOne(targetEntity = Publicacion.class)
    @JoinColumn(name = "id_publicacion")
    @JsonBackReference
    private Publicacion publicacion;

    /*@ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = false)
    @JsonBackReference(value = "publicacion-Comentarios")
    private Publicacion publicacion;*/

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "cedula",nullable = false)
    @JsonBackReference
    private Usuario usuario;

    public Comentario() {
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "idComentario=" + idComentario +
                ", comentario='" + comentario + '\'' +
                ", fechaComentario=" + fechaComentario +
                ", publicacion=" + publicacion +
                ", usuario=" + usuario +
                '}';
    }
}
