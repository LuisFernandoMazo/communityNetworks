package com.talentoTech.communityNetwork.controllers;


import com.talentoTech.communityNetwork.entitys.Comentario;
import com.talentoTech.communityNetwork.entitys.Publicacion;
import com.talentoTech.communityNetwork.services.ComentarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {
    private static final Logger logger = LoggerFactory.getLogger(ComentarioController.class);
    @Autowired
    private ComentarioService comentarioService;


    // Get all Comentario
    @GetMapping
    public ResponseEntity<List<Comentario>> getAllComentarios() {
        List<Comentario> comentarios = comentarioService.getAllComentarios();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    // Create Comentario
    @PostMapping("/crear")
    public ResponseEntity<Comentario> createComentario(
            @RequestParam("idUsuarioComentario") String idUsuarioComentario,
            @RequestParam("id_publicacion") String id_publicacion,
            @RequestParam("fechaComentario") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaComentario,
            @RequestParam("comentario") String comentario
    ) {
        try {
            Comentario savedComentario = comentarioService.saveComentario(comentario, fechaComentario, id_publicacion, idUsuarioComentario);


            return ResponseEntity.ok(savedComentario);


        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }



    }

}
