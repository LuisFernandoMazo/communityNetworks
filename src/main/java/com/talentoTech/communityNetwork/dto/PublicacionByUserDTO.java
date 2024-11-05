package com.talentoTech.communityNetwork.dto;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.entitys.Publicacion;
import com.talentoTech.communityNetwork.entitys.TipoPublicacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PublicacionByUserDTO {
    private Integer idPublicacion;
    private TipoPublicacion tipoPublicacion;
    private Ciudad ciudad;
    private String direccion;
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String images;

    public PublicacionByUserDTO(Integer idPublicacion, TipoPublicacion tipoPublicacion, Ciudad ciudad, String direccion, String titulo, String descripcion, LocalDate fechaPublicacion, LocalDate fechaInicio, LocalDate fechaFin, String images) {
        this.idPublicacion = idPublicacion;
        this.tipoPublicacion = tipoPublicacion;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.images = images;
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
