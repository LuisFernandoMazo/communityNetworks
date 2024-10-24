package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.Comentario;
import com.talentoTech.communityNetwork.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    // Get all Comentarios
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

}
