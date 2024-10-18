package com.talentoTech.communityNetwork.repository;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, String> {
}
