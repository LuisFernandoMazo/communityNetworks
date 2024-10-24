package com.talentoTech.communityNetwork.repository;

import com.talentoTech.communityNetwork.entitys.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {
}
