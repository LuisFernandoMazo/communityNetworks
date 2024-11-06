package com.talentoTech.communityNetwork.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.talentoTech.communityNetwork.dto.UsuarioDTO;
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
    @JsonBackReference(value = "usuario-publicaciones")
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

    private LocalDate fechaPublicacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Column(nullable = false, length = 300)
    private String images;

    /*@OneToMany(mappedBy = "publicacion", fetch = FetchType.LAZY)
    private List<Comentario> comentario;*/

    @OneToMany(targetEntity = Comentario.class,fetch = FetchType.LAZY,mappedBy = "publicacion")
    @JsonManagedReference (value = "publicacion-comentario")
    private List<Comentario> comentario;


    public Publicacion(){
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Usuario getUsuarioPublicador() {
        return usuarioPublicador;
    }

    public void setUsuarioPublicador(Usuario usuarioPublicador) {
        this.usuarioPublicador = usuarioPublicador;
    }

    public TipoPublicacion getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}