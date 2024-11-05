package com.talentoTech.communityNetwork.repository;

import com.talentoTech.communityNetwork.entitys.Publicacion;
import com.talentoTech.communityNetwork.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
    @Query("SELECT p FROM Publicacion p WHERE " +
            "(:query IS NULL OR LOWER(p.titulo) LIKE LOWER(CONCAT('%', :query, '%'))) " +
            "AND (:fecha IS NULL OR p.fechaPublicacion = :fecha) " +
            "AND (:ciudad IS NULL OR p.ciudad.idCiudad = :ciudad) " +
            "AND (:tipo IS NULL OR p.tipoPublicacion.idTipo = :tipo)")
    List<Publicacion> filtrarPorParametros(@Param("query") String query,
                                           @Param("fecha") LocalDate fecha,
                                           @Param("ciudad") String ciudad,
                                           @Param("tipo") String tipo);
}
