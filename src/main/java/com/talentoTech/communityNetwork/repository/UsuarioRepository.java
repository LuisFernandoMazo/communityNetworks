package com.talentoTech.communityNetwork.repository;
import com.talentoTech.communityNetwork.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
