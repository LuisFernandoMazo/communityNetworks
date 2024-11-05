package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.*;
import com.talentoTech.communityNetwork.repository.ComentarioRepository;
import com.talentoTech.communityNetwork.repository.PublicacionRepository;
import com.talentoTech.communityNetwork.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Get all Comentarios
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @Transactional
    public Comentario saveComentario(   String comentario,
                                        LocalDate fechaComentario,
                                        String id_publicacion,
                                        String idUsuarioComentario

                                        )
            throws  Exception{


        Publicacion publicacion = publicacionRepository.findById(Integer.valueOf(id_publicacion)).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        Usuario usuario = usuarioRepository.findById(idUsuarioComentario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Comentario comentario2 = new Comentario();
        comentario2.setComentario(comentario);
        comentario2.setFechaComentario(fechaComentario);
        comentario2.setPublicacion(publicacion);
        comentario2.setUsuario(usuario);

        return comentarioRepository.save(comentario2);
    }


}
