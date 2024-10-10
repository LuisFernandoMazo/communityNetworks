package com.talentoTech.communityNetwork.repository;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, String> {
}
