package com.talentoTech.communityNetwork.repository;

import com.talentoTech.communityNetwork.entitys.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, String> {
}

