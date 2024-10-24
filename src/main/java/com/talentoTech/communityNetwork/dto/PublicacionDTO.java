package com.talentoTech.communityNetwork.dto;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.entitys.Publicacion;
import com.talentoTech.communityNetwork.entitys.TipoPublicacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PublicacionDTO {
    private Integer idPublicacion;
    private UsuarioDTO usuarioPublicador;
    private TipoPublicacion tipoPublicacion;
    private Ciudad ciudad;
    private String direccion;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaPublicacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String images;

    public PublicacionDTO(Publicacion publicacion, UsuarioDTO usuarioDTO){
        this.idPublicacion = publicacion.getIdPublicacion();
        this.usuarioPublicador = usuarioDTO;
        this.tipoPublicacion = publicacion.getTipoPublicacion();
        this.ciudad = publicacion.getCiudad();
        this.direccion = publicacion.getDireccion();
        this.titulo = publicacion.getTitulo();
        this.descripcion = publicacion.getDescripcion();
        this.fechaPublicacion = publicacion.getFechaPublicacion();
        this.fechaInicio = publicacion.getFechaInicio();
        this.fechaFin = publicacion.getFechaFin();
        this.images = publicacion.getImages();
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public UsuarioDTO getUsuarioPublicador() {
        return usuarioPublicador;
    }

    public void setUsuarioPublicador(UsuarioDTO usuarioPublicador) {
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

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
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
